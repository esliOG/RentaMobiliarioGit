package com.tuempresa.rentaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoAdapter(private val lista: List<Producto>) : RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.tvNombre)
        val descripcion: TextView = view.findViewById(R.id.tvDescripcion)
        val precio: TextView = view.findViewById(R.id.tvPrecio)
        val cantidad: TextView = view.findViewById(R.id.tvCantidad)
        val btnMas: Button = view.findViewById(R.id.btnMas)
        val btnMenos: Button = view.findViewById(R.id.btnMenos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = lista[position]
        holder.nombre.text = p.nombre
        holder.descripcion.text = p.descripcion
        holder.precio.text = "$${p.precio}"
        holder.cantidad.text = p.cantidadSeleccionada.toString()

        holder.btnMas.setOnClickListener {
            p.cantidadSeleccionada++
            holder.cantidad.text = p.cantidadSeleccionada.toString()
            (holder.itemView.context as MainActivity).actualizarTotal(lista)
        }

        holder.btnMenos.setOnClickListener {
            if (p.cantidadSeleccionada > 0) {
                p.cantidadSeleccionada--
                holder.cantidad.text = p.cantidadSeleccionada.toString()
                (holder.itemView.context as MainActivity).actualizarTotal(lista)
            }
        }
    }

    override fun getItemCount() = lista.size
}