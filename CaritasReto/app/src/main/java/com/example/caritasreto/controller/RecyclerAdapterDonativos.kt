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
        holder.itemInfoDonativo.setText(donativos.get(position).donativo + " - " + donativos.get(position).aportacion.toString() + " MXN")
        holder.itemFecha.setText(donativos.get(position).fecha)
        if(donativos.get(position).actividad == "act") {
            holder.itemIcon.setImageResource(iconoDonacionActiva)
        }
        else {
            holder.itemIcon.setImageResource(iconoDonacionInactiva)
        }
    }

    override fun getItemCount(): Int {
        return donativos.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemInfoDonativo: TextView
        var itemFecha: TextView
        var itemIcon: ImageView

        init{
            itemIcon = itemView.findViewById(R.id.donativoIcon)
            itemFecha = itemView.findViewById(R.id.fecha)
            itemInfoDonativo = itemView.findViewById(R.id.donativoFrecuencia)
        }
    }

}