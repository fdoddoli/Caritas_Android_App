package com.example.caritasreto.controller


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.Model.Database.Donativo
import com.example.caritasreto.R

class RecyclerAdapterDonativos(listaDonativos: ArrayList<Donativo>): RecyclerView.Adapter<RecyclerAdapterDonativos.ViewHolder>(){
    private val donativos = listaDonativos
    private val iconoDonacionActiva = R.drawable.icono_donacionact
    private val iconoDonacionInactiva = R.drawable.icono_donacioninact

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterDonativos.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.donativo, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterDonativos.ViewHolder, position: Int) {
        holder.itemFrecuencia.setText(donativos.get(position).donativo)
        holder.itemCantidad.setText(donativos.get(position).aportacion.toString() + " MXN")
        if(donativos.get(position).actividad == "act") {
            holder.itemDepartamento.setImageResource(iconoDonacionActiva)
        }
        else {
            holder.itemDepartamento.setImageResource(iconoDonacionInactiva)
        }
    }

    override fun getItemCount(): Int {
        return donativos.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemCantidad: TextView
        var itemFrecuencia: TextView
        var itemDepartamento: ImageView

        init{
            itemDepartamento = itemView.findViewById(R.id.donativoIcon)
            itemCantidad = itemView.findViewById(R.id.donativoCantidad)
            itemFrecuencia = itemView.findViewById(R.id.donativoFrecuencia)
        }
    }

}