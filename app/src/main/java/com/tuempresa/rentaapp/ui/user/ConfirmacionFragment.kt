package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.R

import android.Manifest
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.tuempresa.rentaapp.databinding.FragmentConfirmacionBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.models.CartItem
import com.tuempresa.rentaapp.models.OrderStatus
import com.tuempresa.rentaapp.models.PaymentStatus
import com.tuempresa.rentaapp.models.RentalOrder
import com.tuempresa.rentaapp.utils.NotificationHelper
import java.util.*

class ConfirmacionFragment : Fragment() {

    private var _binding: FragmentConfirmacionBinding? = null
    private val binding get() = _binding!!

    private lateinit var listaProductos: ArrayList<Producto>
    private var total: Double = 0.0

    private var fechaEntregaMs: Long = 0L
    private var fechaDevolucionMs: Long = 0L

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    // Launcher para pedir permiso de notificaciones (Android 13+)
    private val notifPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { /* no-op: el usuario puede denegar, no bloqueamos la acción */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listaProductos = arguments?.getSerializable("productos") as? ArrayList<Producto> ?: arrayListOf()
        total = calcularTotal()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Solicitar permiso de notificaciones si es Android 13+
        pedirPermisoNotificaciones()

        binding.tvTotalConfirmacion.text = "Total a pagar: \$$total"

        var resumen = "Artículos rentados:\n\n"
        listaProductos.forEach {
            resumen += "- ${it.cantidadSeleccionada}x ${it.furniture.nombreProducto} (\$${it.furniture.precio} c/u)\n"
        }
        binding.tvResumenArticulos.text = resumen

        binding.btnFechaEntrega.setOnClickListener {
            mostrarDatePicker { timestamp, fechaString ->
                fechaEntregaMs = timestamp
                binding.btnFechaEntrega.text = "Entrega: $fechaString"
            }
        }

        binding.btnFechaDevolucion.setOnClickListener {
            mostrarDatePicker { timestamp, fechaString ->
                fechaDevolucionMs = timestamp
                binding.btnFechaDevolucion.text = "Devolución: $fechaString"
            }
        }

        binding.btnFinalizarRenta.setOnClickListener {
            if (fechaEntregaMs == 0L || fechaDevolucionMs == 0L) {
                Toast.makeText(requireContext(), "Selecciona ambas fechas", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (fechaDevolucionMs < fechaEntregaMs) {
                Toast.makeText(requireContext(), "Fecha de devolución inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (binding.toggleMetodoPago.checkedButtonId == View.NO_ID) {
                Toast.makeText(requireContext(), "Selecciona un método de pago", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.btnFinalizarRenta.isEnabled = false
            procesarRenta()
        }
    }

    private fun pedirPermisoNotificaciones() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                notifPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    private fun mostrarDatePicker(onDateSelected: (Long, String) -> Unit) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(requireContext(), { _, y, m, d ->
            val sel = Calendar.getInstance()
            sel.set(y, m, d)
            val formatStr = "$d/${m + 1}/$y"
            onDateSelected(sel.timeInMillis, formatStr)
        }, year, month, day).apply {
            datePicker.minDate = System.currentTimeMillis() - 1000
        }.show()
    }

    private fun calcularTotal(): Double {
        return listaProductos.sumOf { (it.furniture.precio * it.cantidadSeleccionada) }
    }

    private fun procesarRenta() {
        val userId = auth.currentUser?.uid
        if (userId == null) {
            Toast.makeText(requireContext(), "Error de sesión", Toast.LENGTH_SHORT).show()
            binding.btnFinalizarRenta.isEnabled = true
            return
        }

        val metodoPago = when (binding.toggleMetodoPago.checkedButtonId) {
            R.id.btnPagoEfectivo -> "Efectivo"
            R.id.btnPagoTransferencia -> "Transferencia bancaria"
            else -> "No especificado"
        }

        val orderId = UUID.randomUUID().toString()
        val cartItems = listaProductos.map {
            CartItem(it.furniture.id, it.cantidadSeleccionada, it.furniture.precio)
        }

        val order = RentalOrder(
            id = orderId,
            userId = userId,
            items = cartItems,
            deliveryDate = fechaEntregaMs,
            returnDate = fechaDevolucionMs,
            status = OrderStatus.PENDING,
            paymentStatus = PaymentStatus.PENDING,
            totalCost = total,
            paymentMethod = metodoPago
        )

        // Transacción Firestore: PRIMERO todas las lecturas, LUEGO todas las escrituras
        db.runTransaction { transaction ->

            // ── FASE 1: TODAS las lecturas ──────────────────────────────────────────
            val snapshots = listaProductos.map { pro ->
                val docRef = db.collection("mobiliario").document(pro.furniture.id)
                Pair(pro, transaction.get(docRef))
            }

            // ── FASE 2: Validar stock ───────────────────────────────────────────────
            snapshots.forEach { (pro, snapshot) ->
                if (!snapshot.exists()) {
                    throw Exception("Producto no encontrado: ${pro.furniture.nombreProducto}")
                }
                val stockActual = snapshot.getLong("existencia") ?: 0
                if (stockActual < pro.cantidadSeleccionada) {
                    throw Exception("Sin stock para: ${pro.furniture.nombreProducto}")
                }
            }

            // ── FASE 3: TODAS las escrituras ───────────────────────────────────────
            snapshots.forEach { (pro, snapshot) ->
                val stockActual = snapshot.getLong("existencia") ?: 0
                val docRef = db.collection("mobiliario").document(pro.furniture.id)
                transaction.update(docRef, "existencia", stockActual - pro.cantidadSeleccionada)
            }

            // Guardar el pedido
            val orderRef = db.collection("rentas").document(orderId)
            transaction.set(orderRef, order)

            null
        }.addOnSuccessListener {
            // Notificación local al usuario
            NotificationHelper.mostrar(
                requireContext(),
                "✅ Renta Confirmada",
                "Tu pedido #${orderId.take(6).uppercase()} ha sido enviado. Total: \$${"%.2f".format(total)}"
            )

            // Escribir notificación en Firestore para el admin
            enviarNotificacionFirestore(
                paraRol = "ADMINISTRADOR",
                paraUserId = null,
                titulo = "🛋️ Nuevo Pedido",
                cuerpo = "Pedido #${orderId.take(6).uppercase()} — \$${"%.2f".format(total)} — Pago: $metodoPago"
            )

            // Buscar el número del admin y abrir WhatsApp
            db.collection("usuarios")
                .whereEqualTo("role", "ADMINISTRADOR")
                .limit(1)
                .get()
                .addOnSuccessListener { querySnapshot ->
                    // Guard: si el Fragment ya no está adjunto, no tocar la UI
                    if (!isAdded || context == null) return@addOnSuccessListener

                    val adminDoc = querySnapshot.documents.firstOrNull()
                    val telefonoAdmin = adminDoc?.getString("phone")

                    if (telefonoAdmin.isNullOrBlank()) {
                        Toast.makeText(
                            requireContext(),
                            "Renta confirmada. No se encontró número del administrador.",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        val numLimpio = telefonoAdmin.filter { it.isDigit() }
                        val numWA = if (numLimpio.length == 10) "52$numLimpio" else numLimpio
                        enviarMensajePrivadoWhatsApp(order, metodoPago, numWA)
                    }

                    (activity as? MainActivity)?.limpiarCarrito()
                    parentFragmentManager.popBackStack()
                }
                .addOnFailureListener {
                    if (!isAdded || context == null) return@addOnFailureListener
                    Toast.makeText(
                        requireContext(),
                        "Renta confirmada. No se pudo contactar al admin por WhatsApp.",
                        Toast.LENGTH_LONG
                    ).show()
                    (activity as? MainActivity)?.limpiarCarrito()
                    parentFragmentManager.popBackStack()
                }

        }.addOnFailureListener { e ->
            Toast.makeText(requireContext(), "Error en el pedido: ${e.message}", Toast.LENGTH_LONG).show()
            binding.btnFinalizarRenta.isEnabled = true
        }
    }

    /**
     * Escribe un documento en la colección "notificaciones" de Firestore.
     * El listener en MainActivity / AdminMainActivity lo leerá y mostrará la notif local.
     */
    private fun enviarNotificacionFirestore(
        paraRol: String?,
        paraUserId: String?,
        titulo: String,
        cuerpo: String
    ) {
        val notif = hashMapOf(
            "paraRol" to paraRol,
            "paraUserId" to paraUserId,
            "titulo" to titulo,
            "cuerpo" to cuerpo,
            "leido" to false,
            "timestamp" to System.currentTimeMillis()
        )
        db.collection("notificaciones").add(notif)
    }

    private fun enviarMensajePrivadoWhatsApp(order: RentalOrder, metodoPago: String, numeroAdmin: String) {
        val cEntrega = Calendar.getInstance().apply { timeInMillis = order.deliveryDate }
        val dE = "${cEntrega.get(Calendar.DAY_OF_MONTH)}/${cEntrega.get(Calendar.MONTH)+1}/${cEntrega.get(Calendar.YEAR)}"

        val cDev = Calendar.getInstance().apply { timeInMillis = order.returnDate }
        val dD = "${cDev.get(Calendar.DAY_OF_MONTH)}/${cDev.get(Calendar.MONTH)+1}/${cDev.get(Calendar.YEAR)}"

        var itemsTxt = ""
        listaProductos.forEach {
            itemsTxt += "  🔸 ${it.cantidadSeleccionada}x ${it.furniture.nombreProducto} — \$${it.furniture.precio} c/u\n"
        }

        val idCorto = order.id.take(8).uppercase()
        val iconoPago = if (metodoPago == "Efectivo") "💵" else "🏦"

        val mensaje = """
¡Hola! Nueva solicitud de renta desde la App 📱

*📋 ID Pedido:* $idCorto

*🪑 Artículos:*
$itemsTxt
*📅 Fechas:*
  Entrega: $dE
  Devolución: $dD

*💰 Total a Pagar:* $${"%.2f".format(order.totalCost)}
*$iconoPago Método de Pago:* $metodoPago

${if (metodoPago == "Transferencia bancaria") "Por favor indícame los datos de la cuenta para realizar el pago. ¡Gracias! 🙏" else "Pagaré en efectivo al momento de la entrega. ¡Gracias! 🙏"}
        """.trimIndent()

        val ctx = context ?: return  // Guard: si no hay contexto válido, salir sin crash

        // ── Intento 1: Abrir WhatsApp directamente (más confiable, sin selector de navegador) ──
        val intentDirecto = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroAdmin&text=${Uri.encode(mensaje)}")
            setPackage("com.whatsapp")
        }

        // ── Intento 2: WhatsApp Business ──
        val intentBusiness = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroAdmin&text=${Uri.encode(mensaje)}")
            setPackage("com.whatsapp.w4b")
        }

        // ── Intento 3: Fallback genérico (navegador o cualquier app que maneje la URL) ──
        val intentFallback = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroAdmin&text=${Uri.encode(mensaje)}")
        }

        val pm = ctx.packageManager
        when {
            intentDirecto.resolveActivity(pm) != null -> {
                Toast.makeText(ctx, "Renta confirmada. Abriendo WhatsApp...", Toast.LENGTH_LONG).show()
                activity?.startActivity(intentDirecto)
            }
            intentBusiness.resolveActivity(pm) != null -> {
                Toast.makeText(ctx, "Renta confirmada. Abriendo WhatsApp Business...", Toast.LENGTH_LONG).show()
                activity?.startActivity(intentBusiness)
            }
            intentFallback.resolveActivity(pm) != null -> {
                Toast.makeText(ctx, "Renta confirmada. Redirigiendo a WhatsApp...", Toast.LENGTH_LONG).show()
                activity?.startActivity(intentFallback)
            }
            else -> {
                // ── Fallback final: Mostrar diálogo con número y mensaje para copiar ──
                mostrarDialogoContactoManual(ctx, numeroAdmin, mensaje)
            }
        }
    }

    /**
     * Fallback cuando WhatsApp no está disponible.
     * Muestra el número del admin y el mensaje formateado en un diálogo copiable.
     */
    private fun mostrarDialogoContactoManual(ctx: Context, numero: String, mensaje: String) {
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        AlertDialog.Builder(ctx)
            .setTitle("📋 Renta Confirmada")
            .setMessage(
                "Tu renta fue registrada exitosamente.\n\n" +
                "WhatsApp no está disponible en este dispositivo.\n" +
                "Contacta al administrador manualmente:\n\n" +
                "📞 Número: $numero\n\n" +
                "Puedes copiar el mensaje del pedido con el botón de abajo."
            )
            .setPositiveButton("Copiar mensaje del pedido") { dialog, _ ->
                val clip = ClipData.newPlainText("Pedido Renta", mensaje)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(ctx, "✅ Mensaje copiado al portapapeles", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cerrar") { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
