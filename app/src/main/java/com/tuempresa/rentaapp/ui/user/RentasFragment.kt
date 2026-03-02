package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.adapters.PedidoAdapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuempresa.rentaapp.databinding.FragmentRentasBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.tuempresa.rentaapp.models.RentalOrder

class RentasFragment : Fragment() {

    private var _binding: FragmentRentasBinding? = null
    private val binding get() = _binding!!

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    private lateinit var adapter: PedidoAdapter
    private var listaPedidos = mutableListOf<RentalOrder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRentasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PedidoAdapter(listaPedidos, esAdmin = false)

        binding.rvMisRentas.layoutManager = LinearLayoutManager(context)
        binding.rvMisRentas.adapter = adapter

        cargarMisPedidos()
    }

    private fun cargarMisPedidos() {
        val uid = auth.currentUser?.uid ?: return

        db.collection("rentas")
            .whereEqualTo("userId", uid)
            // Firebase requiere índice compuesto para where + orderBy. Lo evitamos ordenando localmente por ahora.
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Toast.makeText(context, "Error cargando tus rentas", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    listaPedidos.clear()
                    for (doc in snapshot.documents) {
                        val pedido = doc.toObject(RentalOrder::class.java)
                        if (pedido != null) {
                            listaPedidos.add(pedido)
                        }
                    }
                    // Ordenamos localmente del más reciente
                    listaPedidos.sortByDescending { it.deliveryDate }
                    adapter.actualizarLista(listaPedidos)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
