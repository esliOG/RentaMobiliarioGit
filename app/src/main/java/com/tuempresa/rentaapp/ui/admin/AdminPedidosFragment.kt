package com.tuempresa.rentaapp.ui.admin

import com.tuempresa.rentaapp.adapters.PedidoAdapter

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.databinding.FragmentAdminPedidosBinding
import com.tuempresa.rentaapp.models.OrderStatus
import com.tuempresa.rentaapp.models.RentalOrder
import com.tuempresa.rentaapp.utils.NotificationHelper

class AdminPedidosFragment : Fragment() {

    private var _binding: FragmentAdminPedidosBinding? = null
    private val binding get() = _binding!!

    private val db = FirebaseFirestore.getInstance()
    private lateinit var adapter: PedidoAdapter
    private var listaPedidos = mutableListOf<RentalOrder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminPedidosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PedidoAdapter(listaPedidos, esAdmin = true) { pedido, nuevoEstado ->
            if (nuevoEstado == OrderStatus.APPROVED) {
                actualizarEstadoPedido(pedido, nuevoEstado)
            } else {
                confirmarCambioEstado(pedido, nuevoEstado)
            }
        }

        binding.rvAdminPedidos.layoutManager = LinearLayoutManager(context)
        binding.rvAdminPedidos.adapter = adapter

        cargarTodosLosPedidos()
    }

    private fun cargarTodosLosPedidos() {
        db.collection("rentas")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(context, "Error cargando pedidos", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    listaPedidos.clear()
                    for (doc in snapshot.documents) {
                        val pedido = doc.toObject(RentalOrder::class.java)
                        if (pedido != null) listaPedidos.add(pedido)
                    }
                    listaPedidos.sortByDescending { it.deliveryDate }
                    adapter.actualizarLista(listaPedidos)
                }
            }
    }

    private fun confirmarCambioEstado(pedido: RentalOrder, nuevoEstado: OrderStatus) {
        val accion = if (nuevoEstado == OrderStatus.RETURNED) "Marcar como DEVUELTO" else "CANCELAR pedido"
        AlertDialog.Builder(requireContext())
            .setTitle(accion)
            .setMessage("¿Estás seguro que deseas $accion #${pedido.id.take(6).uppercase()}?\n\nEsto regresará los artículos al stock disponible.")
            .setPositiveButton("Sí, proceder") { _, _ ->
                procesarDevolucionStock(pedido, nuevoEstado)
            }
            .setNegativeButton("Cerrar", null)
            .show()
    }

    private fun procesarDevolucionStock(pedido: RentalOrder, nuevoEstado: OrderStatus) {
        // Transacción Firestore: PRIMERO todas las lecturas, LUEGO todas las escrituras
        db.runTransaction { transaction ->

            // ── FASE 1: TODAS las lecturas ──────────────────────────────────────────
            val snapshots = pedido.items.map { cartItem ->
                val docRef = db.collection("mobiliario").document(cartItem.furnitureId)
                Pair(cartItem, transaction.get(docRef))
            }

            // ── FASE 2: TODAS las escrituras (stock + estado pedido) ───────────────
            snapshots.forEach { (cartItem, snapshot) ->
                if (snapshot.exists()) {
                    val stockActual = snapshot.getLong("existencia") ?: 0
                    val docRef = db.collection("mobiliario").document(cartItem.furnitureId)
                    transaction.update(docRef, "existencia", stockActual + cartItem.quantity)
                }
            }

            val orderRef = db.collection("rentas").document(pedido.id)
            transaction.update(orderRef, "status", nuevoEstado.name)

            null
        }.addOnSuccessListener {
            val estadoTexto = when (nuevoEstado) {
                OrderStatus.RETURNED -> "devuelto"
                OrderStatus.CANCELLED -> "cancelado"
                else -> nuevoEstado.name.lowercase()
            }

            // Notificación local al admin
            NotificationHelper.mostrar(
                requireContext(),
                "✅ Pedido Actualizado",
                "Pedido #${pedido.id.take(6).uppercase()} marcado como $estadoTexto. Stock recuperado."
            )

            // Notificación Firestore para el usuario dueño del pedido
            enviarNotificacionFirestore(
                paraUserId = pedido.userId,
                titulo = when (nuevoEstado) {
                    OrderStatus.RETURNED -> "📦 Renta Completada"
                    OrderStatus.CANCELLED -> "❌ Renta Cancelada"
                    else -> "🔄 Estado Actualizado"
                },
                cuerpo = "Tu pedido #${pedido.id.take(6).uppercase()} fue $estadoTexto."
            )

            Toast.makeText(context, "Estado actualizado y stock recuperado", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener { e ->
            Toast.makeText(context, "Error al actualizar: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun actualizarEstadoPedido(pedido: RentalOrder, nuevoEstado: OrderStatus) {
        db.collection("rentas").document(pedido.id)
            .update("status", nuevoEstado.name)
            .addOnSuccessListener {
                // Notificación local al admin
                NotificationHelper.mostrar(
                    requireContext(),
                    "✅ Pedido Aprobado",
                    "Pedido #${pedido.id.take(6).uppercase()} marcado como Aprobado."
                )

                // Notificación Firestore para el usuario
                enviarNotificacionFirestore(
                    paraUserId = pedido.userId,
                    titulo = "🎉 Renta Aprobada",
                    cuerpo = "Tu pedido #${pedido.id.take(6).uppercase()} fue aprobado. ¡Te esperamos!"
                )

                Toast.makeText(context, "Pedido marcado como Aprobado", Toast.LENGTH_SHORT).show()
            }
    }

    /**
     * Escribe un documento en "notificaciones" en Firestore.
     * El listener en MainActivity lo leerá y mostrará la notif local al usuario.
     */
    private fun enviarNotificacionFirestore(
        paraUserId: String,
        titulo: String,
        cuerpo: String
    ) {
        val notif = hashMapOf(
            "paraRol" to null,
            "paraUserId" to paraUserId,
            "titulo" to titulo,
            "cuerpo" to cuerpo,
            "leido" to false,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("notificaciones").add(notif)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
