package com.tuempresa.rentaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class CatalogoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_catalogo, container, false)

        recyclerView = view.findViewById(R.id.rvProductos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        consultarProductos()

        return view
    }

    private fun consultarProductos() {
        val db = FirebaseFirestore.getInstance()
        db.collection("productos").addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                val lista = snapshot.toObjects(Producto::class.java)
                recyclerView.adapter = ProductoAdapter(lista)
            }
        }
    }
}