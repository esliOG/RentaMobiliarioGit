package com.tuempresa.rentaapp.ui.common

import com.tuempresa.rentaapp.ui.auth.LoginActivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tuempresa.rentaapp.databinding.FragmentPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cargarDatosUsuario()

        binding.btnGuardarPerfil.setOnClickListener {
            guardarDatosUsuario()
        }

        binding.btnCerrarSesion.setOnClickListener {
            auth.signOut()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            // Clear entire task stack so user can't press back to go back into the app
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun cargarDatosUsuario() {
        val userId = auth.currentUser?.uid ?: return

        db.collection("usuarios").document(userId).get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    binding.etNombrePerfil.setText(document.getString("nombreUsuario"))
                    binding.etTelefonoPerfil.setText(document.getString("telefono"))
                    binding.etEmailPerfil.setText(document.getString("email"))
                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error cargando perfil", Toast.LENGTH_SHORT).show()
            }
    }

    private fun guardarDatosUsuario() {
        val userId = auth.currentUser?.uid ?: return
        val nuevoNombre = binding.etNombrePerfil.text.toString().trim()
        val nuevoTelefono = binding.etTelefonoPerfil.text.toString().trim()

        if (nuevoNombre.isEmpty() || nuevoTelefono.isEmpty()) {
            Toast.makeText(context, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show()
            return
        }

        val updates = mapOf(
            "nombreUsuario" to nuevoNombre,
            "telefono" to nuevoTelefono
        )

        db.collection("usuarios").document(userId).update(updates)
            .addOnSuccessListener {
                Toast.makeText(context, "Perfil actualizado", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Error al actualizar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
