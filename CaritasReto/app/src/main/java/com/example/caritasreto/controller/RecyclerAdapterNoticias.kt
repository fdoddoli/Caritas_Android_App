package com.example.caritasreto.controller

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils
import com.example.caritasreto.Model.Noticias

class RecyclerAdapterNoticias: RecyclerView.Adapter<RecyclerAdapterNoticias.ViewHolder>(){
    private var images = intArrayOf(R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios, R.drawable.voluntarios)
    var filtro = ArrayList<String>()
    var items = ArrayList<Noticias>()
    var listaFiltrada = ArrayList<Noticias>()
    var listaFinal = ArrayList<Noticias>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterNoticias.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        listaFiltrada = filtrado(filtro, items)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d("tamañolistaf", listaFiltrada.size.toString())
        for (datos in listaFiltrada){
            Log.d("datosfiltrados", datos.category)
        }
        var position2 = position % 10
        if (!filtro.isEmpty()) {
            Log.d("valor", filtro[0])
        }
        if (!items.isEmpty()){
            Log.d("valor-lista", items[0].category)
        }
        if (!listaFiltrada.isEmpty()){
            Log.d("valor-filtrado", listaFiltrada[0].category)
        }

        if(listaFiltrada.isEmpty()){
            Log.d("conf", "Si esta vacia")
            listaFinal = items
        } else{
            listaFinal = listaFiltrada
            Log.d("size", listaFinal.size.toString())
            position2 = listaFiltrada.size - 1
        }

        if(this.listaFinal.size != 0){
            println(this.listaFinal.size)
            holder.itemTitle.text = this.listaFinal[position2].getTitulo()
            holder.itemDescription.text = this.listaFinal[position2].getDescipcion()
            holder.itemImage.setImageResource(images[position2])
            holder.itemCategoria.setText(listaFinal[position2].getCategoria())
        }

        //Click Listener on Item
        //Pasamos arguments con bundle
        //Title = titles[position]
        //Details = details[position]
        //image = images[position]
        holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val verMasFragment = VerMas()
                val bundle = Bundle()
                bundle.putString("titulo", this@RecyclerAdapterNoticias.listaFinal[position2].getTitulo())
                bundle.putString("details", this@RecyclerAdapterNoticias.listaFinal[position2].getDescipcion())
                bundle.putInt("imageV", images[position2])
                verMasFragment.arguments = bundle
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, verMasFragment).addToBackStack(null).commit()
            }
        })

    }

    override fun getItemCount(): Int {
        var listaFiltrada = filtrado(filtro, items)
        if(listaFiltrada.isEmpty()){
            return this.items.size
        } else{
            return listaFiltrada.size
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDescription: TextView
        var itemCategoria: Button
        init{
            itemImage = itemView.findViewById(R.id.Image)
            itemTitle = itemView.findViewById(R.id.Title)
            itemDescription = itemView.findViewById(R.id.Description)
            itemCategoria = itemView.findViewById(R.id.categoria)
        }
    }

    fun filtrado(lista1: ArrayList<String>, lista2: ArrayList<Noticias>): ArrayList<Noticias>{
        var lista3: ArrayList<Noticias> = arrayListOf()
        for (elements1 in lista1){
            for (elements2 in lista2){
                if (elements1 == elements2.category){
                    lista3.add(elements2)
                }
            }
        }
        return lista3
    }

//    private fun filtrarItems(){
//        itemsFiltrados = items.filter{filtro.indexOf(it.getCategoria()) != -1} as ArrayList<Noticias>
//    }



}