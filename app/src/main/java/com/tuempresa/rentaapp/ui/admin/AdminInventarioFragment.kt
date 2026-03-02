package com.tuempresa.rentaapp.ui.admin

import com.tuempresa.rentaapp.R

import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.adapters.AdminProductoAdapter

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.databinding.FragmentAdminInventarioBinding
import com.tuempresa.rentaapp.models.FurnitureItem
import java.util.UUID

class AdminInventarioFragment : Fragment() {

    private var _binding: FragmentAdminInventarioBinding? = null
    // Evitamos el crash si viewBinding falla, aunque en onCreate validaremos su inflado.
    private val binding get() = _binding!! 

    private val db = FirebaseFirestore.getInstance()
    private lateinit var adapter: AdminProductoAdapter
    private var listaMobiliario = mutableListOf<FurnitureItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAdminInventarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AdminProductoAdapter(
            productos = listaMobiliario,
            onEditClick = { producto -> mostrarDialogoProducto(producto) },
            onDeleteClick = { producto -> confirmarEliminacion(producto) }
        )

        binding.rvAdminProductos.layoutManager = LinearLayoutManager(context)
        binding.rvAdminProductos.adapter = adapter

        binding.fabAgregarProducto.setOnClickListener {
            mostrarDialogoProducto(null)
        }

        cargarInventario()
    }

    private fun cargarInventario() {
        db.collection("mobiliario").addSnapshotListener { snapshot, e ->
            if (e != null) {
                Toast.makeText(context, "Error al cargar catálogo", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }

            if (snapshot != null) {
                listaMobiliario.clear()
                for (doc in snapshot.documents) {
                    val item = doc.toObject(FurnitureItem::class.java)
                    if (item != null) {
                        listaMobiliario.add(item)
                    }
                }
                adapter.actualizarLista(listaMobiliario)
            }
        }
    }

    private fun mostrarDialogoProducto(productoExistente: FurnitureItem?) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_admin_producto, null)
        
        val tvTitulo = dialogView.findViewById<TextView>(R.id.tvDialogTitulo)
        val etNombre = dialogView.findViewById<EditText>(R.id.etDialogNombre)
        val etDesc = dialogView.findViewById<EditText>(R.id.etDialogDesc)
        val etPrecio = dialogView.findViewById<EditText>(R.id.etDialogPrecio)
        val etStock = dialogView.findViewById<EditText>(R.id.etDialogStock)
        val btnCancelar = dialogView.findViewById<Button>(R.id.btnDialogCancelar)
        val btnGuardar = dialogView.findViewById<Button>(R.id.btnDialogGuardar)

        if (productoExistente != null) {
            tvTitulo.text = "Editar Producto"
            etNombre.setText(productoExistente.nombreProducto)
            etDesc.setText(productoExistente.descripcion)
            etPrecio.setText(productoExistente.precio.toString())
            etStock.setText(productoExistente.totalStock.toString())
        } else {
            tvTitulo.text = "Agregar Producto"
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)
            .create()

        btnCancelar.setOnClickListener { dialog.dismiss() }

        btnGuardar.setOnClickListener {
            val name = etNombre.text.toString().trim()
            val desc = etDesc.text.toString().trim()
            val priceStr = etPrecio.text.toString().trim()
            val stockStr = etStock.text.toString().trim()

            if (name.isEmpty() || desc.isEmpty() || priceStr.isEmpty() || stockStr.isEmpty()) {
                Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val price = priceStr.toDoubleOrNull() ?: 0.0
            val totalStock = stockStr.toIntOrNull() ?: 0

            val id = productoExistente?.id ?: UUID.randomUUID().toString()
            
            // Si es nuevo, available == total. Si se edita, calculamos la diferencia.
            val availableStock = if (productoExistente != null) {
                val diferencia = totalStock - productoExistente.totalStock
                productoExistente.existencia + diferencia
            } else {
                totalStock
            }

            val nuevoProducto = FurnitureItem(
                id = id,
                nombreProducto = name,
                descripcion = desc,
                precio = price,
                totalStock = totalStock,
                existencia = availableStock,
                imageUrl = productoExistente?.imageUrl ?: ""
            )

            guardarEnFirestore(nuevoProducto)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun guardarEnFirestore(producto: FurnitureItem) {
        db.collection("mobiliario").document(producto.id).set(producto)
            .addOnSuccessListener {
                Toast.makeText(context, "Producto guardado", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error al guardar", Toast.LENGTH_SHORT).show()
            }
    }

    private fun confirmarEliminacion(producto: FurnitureItem) {
        AlertDialog.Builder(requireContext())
            .setTitle("Eliminar Producto")
            .setMessage("¿Estás seguro de que deseas eliminar '${producto.nombreProducto}' del catálogo?")
            .setPositiveButton("Eliminar") { _, _ ->
                db.collection("mobiliario").document(producto.id).delete()
                    .addOnSuccessListener {
                        Toast.makeText(context, "Producto eliminado", Toast.LENGTH_SHORT).show()
                    }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
