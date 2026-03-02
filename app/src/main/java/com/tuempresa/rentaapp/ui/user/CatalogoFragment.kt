package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.adapters.ProductoAdapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.databinding.FragmentCatalogoBinding
import com.tuempresa.rentaapp.models.FurnitureItem

class CatalogoFragment : Fragment(), ProductoAdapter.OnCantidadChangeListener {

    private var _binding: FragmentCatalogoBinding? = null
    private val binding get() = _binding!!

    private var listaWrapperProductos = mutableListOf<Producto>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvProductos.layoutManager = LinearLayoutManager(requireContext())

        binding.btnConfirmarRenta.setOnClickListener {
            val seleccionados = listaWrapperProductos.filter { it.cantidadSeleccionada > 0 }

            if (seleccionados.isEmpty()) {
                Toast.makeText(requireContext(), "Selecciona al menos un producto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            (activity as? MainActivity)?.irConfirmacion(seleccionados)
                ?: Toast.makeText(requireContext(), "Error de navegación", Toast.LENGTH_SHORT).show()
        }

        consultarProductos()
    }

    private fun consultarProductos() {
        db.collection("mobiliario")
            .whereGreaterThan("totalStock", 0) // No mostrar cosas dadas de baja
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Toast.makeText(requireContext(), "Error al cargar catálogo", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    listaWrapperProductos.clear()
                    for (doc in snapshot.documents) {
                        val item = doc.toObject(FurnitureItem::class.java)
                        if (item != null) {
                            listaWrapperProductos.add(Producto(furniture = item, cantidadSeleccionada = 0))
                        }
                    }
                    binding.rvProductos.adapter = ProductoAdapter(listaWrapperProductos, this)
                }
            }
    }

    override fun onCantidadChanged() {
        (activity as? MainActivity)?.actualizarTotal(listaWrapperProductos)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
