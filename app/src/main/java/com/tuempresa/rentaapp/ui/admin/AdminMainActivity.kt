package com.tuempresa.rentaapp.ui.admin

import com.tuempresa.rentaapp.R
import com.tuempresa.rentaapp.ui.common.PerfilFragment
import com.tuempresa.rentaapp.utils.NotificationHelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.tuempresa.rentaapp.databinding.ActivityAdminMainBinding

class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMainBinding

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private var notifListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NotificationHelper.createChannel(this)

        // Cargar fragment inicial
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_fragmentos, AdminInventarioFragment())
                .commit()
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_admin_inventario -> AdminInventarioFragment()
                R.id.nav_admin_pedidos -> AdminPedidosFragment()
                R.id.nav_perfil -> PerfilFragment()
                else -> null
            }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor_fragmentos, it)
                    .commit()
            }
            true
        }

        // Escuchar notificaciones de Firestore dirigidas al rol ADMINISTRADOR
        escucharNotificaciones()
    }

    private fun escucharNotificaciones() {
        notifListener = db.collection("notificaciones")
            .whereEqualTo("paraRol", "ADMINISTRADOR")
            .whereEqualTo("leido", false)
            .addSnapshotListener { snapshot, e ->
                if (e != null || snapshot == null) return@addSnapshotListener
                for (doc in snapshot.documents) {
                    val titulo = doc.getString("titulo") ?: "Notificación"
                    val cuerpo = doc.getString("cuerpo") ?: ""
                    NotificationHelper.mostrar(this, titulo, cuerpo)
                    // Marcar como leído para no volver a mostrarlo
                    doc.reference.update("leido", true)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        notifListener?.remove()
    }
}
