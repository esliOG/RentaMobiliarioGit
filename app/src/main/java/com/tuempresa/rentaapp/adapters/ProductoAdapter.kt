package com.tuempresa.rentaapp.adapters

import com.tuempresa.rentaapp.R

import com.tuempresa.rentaapp.models.Producto

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoAdapter(
    private val lista: List<Producto>,
    private val listener: OnCantidadChangeListener
) : RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    interface OnCantidadChangeListener {
        fun onCantidadChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.tvNombre)
        val descripcion: TextView = view.findViewById(R.id.tvDescripcion)
        val precio: TextView = view.findViewById(R.id.tvPrecio)
        val stockDisp: TextView = view.findViewById(R.id.tvStockDisponible)
        val cantidad: TextView = view.findViewById(R.id.tvCantidad)
        val btnMas: Button = view.findViewById(R.id.btnMas)
        val btnMenos: Button = view.findViewById(R.id.btnMenos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = lista[position]
        val item = p.furniture

        holder.nombre.text = item.nombreProducto
        holder.descripcion.text = item.descripcion
        holder.precio.text = "$${item.precio}"
        
        holder.stockDisp.text = "Disponibles: ${item.existencia}"
        if (item.existencia == 0) {
            holder.stockDisp.setTextColor(Color.RED)
            holder.stockDisp.text = "Agotado"
        } else {
            holder.stockDisp.setTextColor(Color.parseColor("#4CAF50"))
        }

        holder.cantidad.text = p.cantidadSeleccionada.toString()

        holder.btnMas.setOnClickListener {
            if (p.cantidadSeleccionada < item.existencia) {
                p.cantidadSeleccionada++
                holder.cantidad.text = p.cantidadSeleccionada.toString()
                listener.onCantidadChanged()
            }
        }

        holder.btnMenos.setOnClickListener {
            if (p.cantidadSeleccionada > 0) {
                p.cantidadSeleccionada--
                holder.cantidad.text = p.cantidadSeleccionada.toString()
                listener.onCantidadChanged()
            }
        }
    }

    override fun getItemCount() = lista.size
}
