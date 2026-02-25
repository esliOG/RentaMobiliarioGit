package com.tuempresa.rentaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var totalGeneral: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        if (savedInstanceState == null) {
            cambiarPantalla(CatalogoFragment())
        }

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_catalogo -> {
                    cambiarPantalla(CatalogoFragment())
                    true
                }
                R.id.nav_rentas -> {
                    cambiarPantalla(RentasFragment())
                    true
                }
                R.id.nav_perfil -> {
                    cambiarPantalla(PerfilFragment())
                    true
                }
                else -> false
            }
        }
    }


    fun actualizarTotal(lista: List<Producto>) {
        totalGeneral = 0.0
        for (producto in lista) {
            totalGeneral += (producto.precio * producto.cantidadSeleccionada)
        }
    }

    private fun cambiarPantalla(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor_fragmentos, fragment)
            .commit()
    }
}