package com.tuempresa.rentaapp.ui.user

import com.tuempresa.rentaapp.R
import com.tuempresa.rentaapp.models.Producto
import com.tuempresa.rentaapp.ui.common.PerfilFragment
import com.tuempresa.rentaapp.utils.NotificationHelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class MainActivity : AppCompatActivity() {

    var totalGeneral: Double = 0.0

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private var notifListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NotificationHelper.createChannel(this)

        // Cargar fragment inicial
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_fragmentos, CatalogoFragment())
                .commit()
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_catalogo -> CatalogoFragment()
                R.id.nav_rentas -> RentasFragment()
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

        // Escuchar notificaciones de Firestore dirigidas a este usuario
        escucharNotificaciones()
    }

    private fun escucharNotificaciones() {
        val userId = auth.currentUser?.uid ?: return

        notifListener = db.collection("notificaciones")
            .whereEqualTo("paraUserId", userId)
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

    fun irConfirmacion(productosSeleccionados: List<Producto>) {
        val fragment = ConfirmacionFragment()
        val bundle = Bundle()
        bundle.putSerializable("productos", ArrayList(productosSeleccionados))
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor_fragmentos, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun actualizarTotal(lista: List<Producto>) {
        totalGeneral = lista.sumOf { it.furniture.precio * it.cantidadSeleccionada }
    }

    fun limpiarCarrito() {
        totalGeneral = 0.0
    }
}
