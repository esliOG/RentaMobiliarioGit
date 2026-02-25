package com.tuempresa.rentaapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegistroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            irAlMenuPrincipal()
        }

        setContentView(R.layout.activity_registro)

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)

        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()

            if (nombre.isNotEmpty() && telefono.length == 10) {
                guardarUsuarioYEntrar(nombre, telefono)
            } else {
                Toast.makeText(this, "Ingresa nombre y teléfono válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun guardarUsuarioYEntrar(nombre: String, telefono: String) {
        val userMap = hashMapOf("nombre" to nombre, "telefono" to telefono)
        db.collection("usuarios").document(telefono).set(userMap)
            .addOnSuccessListener {
                Toast.makeText(this, "¡Bienvenido $nombre!", Toast.LENGTH_SHORT).show()
                irAlMenuPrincipal()
            }
    }

    private fun irAlMenuPrincipal() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}