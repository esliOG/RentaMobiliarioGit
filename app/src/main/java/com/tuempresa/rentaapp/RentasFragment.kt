package com.tuempresa.rentaapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class RentasFragment : Fragment() {

    private var fechaSeleccionada = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rentas, container, false)

        val calendario = view.findViewById<CalendarView>(R.id.calendarioRenta)
        val tvTotal = view.findViewById<TextView>(R.id.tvTotalPrecio)
        val btnPagar = view.findViewById<Button>(R.id.btnFinalizarRenta)

        val mainActivity = activity as? MainActivity
        val total = mainActivity?.totalGeneral ?: 0.0
        tvTotal.text = "Total a pagar: $$total"

        calendario.setOnDateChangeListener { _, year, month, dayOfMonth ->
            fechaSeleccionada = "$dayOfMonth/${month + 1}/$year"
        }

        btnPagar.setOnClickListener {
            if (fechaSeleccionada.isEmpty()) {
                Toast.makeText(context, "Por favor selecciona una fecha", Toast.LENGTH_SHORT).show()
            } else if (total <= 0) {
                Toast.makeText(context, "El carrito está vacío", Toast.LENGTH_SHORT).show()
            } else {
                enviarPedidoAWhatsApp(total, fechaSeleccionada)
            }
        }
        return view
    }

    private fun enviarPedidoAWhatsApp(total: Double, fecha: String) {
        val mensaje = "¡Hola! Quiero rentar mobiliario para el día $fecha. El total de mi cotización es: $$total"
        val numeroTelefono = "521XXXXXXXXXX"

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroTelefono&text=${Uri.encode(mensaje)}")
        startActivity(intent)
    }
}