package com.tuempresa.rentaapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        val tvNombre = view.findViewById<TextView>(R.id.tvNombrePerfil)
        val tvTelefono = view.findViewById<TextView>(R.id.tvTelefonoPerfil)
        val btnSalir = view.findViewById<Button>(R.id.btnCerrarSesion)

        val userId = FirebaseAuth.getInstance().currentUser?.uid
        if (userId != null) {
            FirebaseFirestore.getInstance().collection("usuarios").document(userId).get()
                .addOnSuccessListener { document ->
                    val nombreReal = document.getString("nombre")
                    val telefonoReal = document.getString("telefono")

                    tvNombre.text = "¡Hola, ${nombreReal ?: "Usuario"}!"
                    tvTelefono.text = telefonoReal ?: "Sin teléfono"
                }
        }

        btnSalir.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(requireContext(), RegistroActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
     }
    }