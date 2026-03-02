package com.tuempresa.rentaapp.adapters

import com.tuempresa.rentaapp.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuempresa.rentaapp.models.FurnitureItem

class AdminProductoAdapter(
    private var productos: List<FurnitureItem>,
    private val onEditClick: (FurnitureItem) -> Unit,
    private val onDeleteClick: (FurnitureItem) -> Unit
) : RecyclerView.Adapter<AdminProductoAdapter.AdminViewHolder>() {

    class AdminViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvAdminNombreProd)
        val tvDesc: TextView = view.findViewById(R.id.tvAdminDescProd)
        val tvPrecio: TextView = view.findViewById(R.id.tvAdminPrecioProd)
        val tvStock: TextView = view.findViewById(R.id.tvAdminStockProd)
        val btnEditar: Button = view.findViewById(R.id.btnAdminEditar)
        val btnEliminar: Button = view.findViewById(R.id.btnAdminEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_admin_producto, parent, false)
        return AdminViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminViewHolder, position: Int) {
        val producto = productos[position]

        holder.tvNombre.text = producto.nombreProducto
        holder.tvDesc.text = producto.descripcion
        holder.tvPrecio.text = "$${producto.precio}"
        holder.tvStock.text = "Stock: ${producto.totalStock} (Disp: ${producto.existencia})"

        holder.btnEditar.setOnClickListener { onEditClick(producto) }
        holder.btnEliminar.setOnClickListener { onDeleteClick(producto) }
    }

    override fun getItemCount(): Int = productos.size

    fun actualizarLista(nuevaLista: List<FurnitureItem>) {
        productos = nuevaLista
        notifyDataSetChanged()
    }
}
