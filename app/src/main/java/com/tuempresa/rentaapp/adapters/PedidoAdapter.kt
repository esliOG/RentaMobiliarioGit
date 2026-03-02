package com.tuempresa.rentaapp.adapters

import com.tuempresa.rentaapp.R

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuempresa.rentaapp.models.OrderStatus
import com.tuempresa.rentaapp.models.RentalOrder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PedidoAdapter(
    private var pedidos: List<RentalOrder>,
    private val esAdmin: Boolean,
    private val onEstadoCambiado: ((RentalOrder, OrderStatus) -> Unit)? = null
) : RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>() {

    class PedidoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId: TextView = view.findViewById(R.id.tvPedidoId)
        val tvEstado: TextView = view.findViewById(R.id.tvPedidoEstado)
        val tvFechas: TextView = view.findViewById(R.id.tvPedidoFechas)
        val tvTotal: TextView = view.findViewById(R.id.tvPedidoTotal)
        val tvItems: TextView = view.findViewById(R.id.tvPedidoItems)
        val llAdmin: LinearLayout = view.findViewById(R.id.llAdminControles)
        val separator: View = view.findViewById(R.id.viewSeparador)
        val btnDevuelto: Button = view.findViewById(R.id.btnMarcarDevuelto)
        val btnCancelado: Button = view.findViewById(R.id.btnMarcarCancelado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pedido, parent, false)
        return PedidoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val pedido = pedidos[position]

        holder.tvId.text = "Pedido #${pedido.id.take(6).uppercase()}"
        holder.tvTotal.text = "Total: $${pedido.totalCost}"

        holder.tvEstado.text = pedido.status.name
        when (pedido.status) {
            OrderStatus.PENDING -> holder.tvEstado.setTextColor(Color.parseColor("#FF9800"))
            OrderStatus.APPROVED -> holder.tvEstado.setTextColor(Color.parseColor("#2196F3"))
            OrderStatus.IN_PROGRESS -> holder.tvEstado.setTextColor(Color.parseColor("#9C27B0"))
            OrderStatus.RETURNED -> holder.tvEstado.setTextColor(Color.parseColor("#4CAF50"))
            OrderStatus.CANCELLED -> holder.tvEstado.setTextColor(Color.RED)
        }

        val sdf = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        val fe = sdf.format(Date(pedido.deliveryDate))
        val fd = sdf.format(Date(pedido.returnDate))
        holder.tvFechas.text = "Entrega: $fe  |  Devolución: $fd"

        // Mostrar sumario de items expandido 
        var cants = "Artículos:"
        pedido.items.forEach { 
            // Podríamos consultar el nombre a Firestore, pero por simplicidad mostramos ID
            cants += "\n- ${it.quantity}x articulo (ID:${it.furnitureId.take(4)})"
        }
        holder.tvItems.text = cants
        holder.tvItems.visibility = View.VISIBLE

        if (esAdmin) {
            holder.llAdmin.visibility = View.VISIBLE
            holder.separator.visibility = View.VISIBLE

            // Solo mostrar controles si NO ha sido cerrado
            if (pedido.status == OrderStatus.RETURNED || pedido.status == OrderStatus.CANCELLED) {
                holder.btnDevuelto.visibility = View.GONE
                holder.btnCancelado.visibility = View.GONE
            } else {
                holder.btnDevuelto.visibility = View.VISIBLE
                holder.btnCancelado.visibility = View.VISIBLE
            }

            holder.btnDevuelto.setOnClickListener { onEstadoCambiado?.invoke(pedido, OrderStatus.RETURNED) }
            holder.btnCancelado.setOnClickListener { onEstadoCambiado?.invoke(pedido, OrderStatus.CANCELLED) }

            // Permite marcar aprobado (solo visual temporal)
            holder.itemView.setOnLongClickListener {
                 if (pedido.status == OrderStatus.PENDING) {
                     onEstadoCambiado?.invoke(pedido, OrderStatus.APPROVED)
                 }
                 true
            }
        }
    }

    override fun getItemCount(): Int = pedidos.size

    fun actualizarLista(nuevaLista: List<RentalOrder>) {
        pedidos = nuevaLista
        notifyDataSetChanged()
    }
}
