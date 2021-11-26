package com.example.caritasreto.controller

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.Model.Donaciones
import com.example.caritasreto.Model.Noticias
import com.example.caritasreto.R

class RecyclerAdapterDonativos: RecyclerView.Adapter<RecyclerAdapterDonativos.ViewHolder>(){
    private val cantidad = arrayOf("500","200")
    private val frecuencia = arrayOf("Mensual","Anual")
    private var departamento = intArrayOf(R.drawable.icono_1,R.drawable.icono_1 )
    var items = ArrayList<Donaciones>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterDonativos.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.donativo, parent, false)
        items = llenado(cantidad, frecuencia)
        Log.d("prueba2", items.size.toString())
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterDonativos.ViewHolder, position: Int) {
        holder.itemCantidad.text = items[position].getCantidad()
        holder.itemFrecuencia.text = items[position].getFrecuencia()
        holder.itemDepartamento.setImageResource(departamento[position])

        val Profile = Profile()
        val bundle = Bundle()
        bundle.putString("numberD", items.size.toString())
        Profile.arguments = bundle
    }

    override fun getItemCount(): Int {
        var items = llenado(cantidad, frecuencia)
        if(items.isEmpty()){
            return this.cantidad.size
        } else{
            return items.size
        }
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

    fun llenado(lista1: Array<String>, lista2: Array<String>): ArrayList<Donaciones>{
        var lista3: ArrayList<Donaciones> = arrayListOf()
        for (i in lista1.indices){
            lista3.add(Donaciones())
            lista3[i].amount = lista1[i]
            lista3[i].frequency = lista2[i]
        }
        return lista3
    }

}