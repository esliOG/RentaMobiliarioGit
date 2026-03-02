package com.tuempresa.rentaapp.ui.auth

import com.tuempresa.rentaapp.ui.admin.AdminMainActivity
import com.tuempresa.rentaapp.ui.user.MainActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tuempresa.rentaapp.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tuempresa.rentaapp.models.Role
import com.tuempresa.rentaapp.models.User

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Si ya hay un usuario logueado, ir directo
        if (auth.currentUser != null) {
            irAlMenuPrincipal()
            return
        }

        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val telefono = binding.etTelefono.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val esAdmin = binding.switchAdminRole.isChecked

            if (nombre.isEmpty() || telefono.length < 10 || email.isEmpty() || password.length < 6) {
                Toast.makeText(this, "Por favor completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registrarUsuarioEnFirebase(nombre, telefono, email, password, esAdmin)
        }

        binding.tvIrAlLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun registrarUsuarioEnFirebase(nombre: String, telefono: String, email: String, password: String, esAdmin: Boolean) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val firebaseUser = auth.currentUser
                    if (firebaseUser != null) {
                        guardarDatosUsuario(firebaseUser.uid, nombre, email, telefono, esAdmin)
                    }
                } else {
                    Toast.makeText(this, "Error de registro: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun guardarDatosUsuario(uid: String, nombre: String, email: String, telefono: String, esAdmin: Boolean) {
        val rolElegido = if (esAdmin) Role.ADMINISTRADOR else Role.CLIENTE
        val user = User(
            id = uid,
            nombreUsuario = nombre,
            email = email,
            telefono = telefono,
            role = rolElegido
        )

        db.collection("usuarios").document(uid).set(user)
            .addOnSuccessListener {
                Toast.makeText(this, "¡Bienvenido $nombre!", Toast.LENGTH_SHORT).show()
                irAlMenuPrincipal()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error guardando datos: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun irAlMenuPrincipal() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            db.collection("usuarios").document(currentUser.uid).get()
                .addOnSuccessListener { document ->
                    if (document.exists() && document.getString("role") == "ADMINISTRADOR") {
                        startActivity(Intent(this, AdminMainActivity::class.java))
                    } else {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    finish()
                }
                .addOnFailureListener {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
        }
    }
}
