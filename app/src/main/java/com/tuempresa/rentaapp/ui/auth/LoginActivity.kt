package com.tuempresa.rentaapp.ui.auth

import com.tuempresa.rentaapp.ui.admin.AdminMainActivity
import com.tuempresa.rentaapp.ui.user.MainActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.tuempresa.rentaapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Si ya hay sesión activa, ir directo al menú y cerrar login
        if (auth.currentUser != null) {
            irAlMenuPrincipal()
            return
        }

        binding.btnContinuar.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingresa tu correo y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            iniciarSesion(email, password)
        }

        binding.tvIrAlRegistro.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
            finish()
        }
    }

    private fun iniciarSesion(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    irAlMenuPrincipal()
                } else {
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun irAlMenuPrincipal() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val db = com.google.firebase.firestore.FirebaseFirestore.getInstance()
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
                    // Fallback to client if failure
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
        }
    }
}
