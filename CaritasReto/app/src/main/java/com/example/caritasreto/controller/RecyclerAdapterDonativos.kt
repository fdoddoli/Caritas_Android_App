package com.example.caritasreto.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.R

class RecyclerAdapterDonativos: RecyclerView.Adapter<RecyclerAdapterDonativos.ViewHolder>(){
    private val cantidad = arrayOf("500","200")
    private val frecuencia = arrayOf("Mensual","Anual")
    private var departamento = intArrayOf(R.drawable.icono_1,R.drawable.icono_1 )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterDonativos.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.donativo, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterDonativos.ViewHolder, position: Int) {
        holder.itemCantidad.text = cantidad[position]
        holder.itemFrecuencia.text = frecuencia[position]
        holder.itemDepartamento.setImageResource(departamento[position])
    }

    override fun getItemCount(): Int {
        return cantidad.size
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