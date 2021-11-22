package com.example.caritasreto.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.R
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.caritasreto.Model.Noticias

class RecyclerAdapterNoticias: RecyclerView.Adapter<RecyclerAdapterNoticias.ViewHolder>(){
    private val titles = arrayOf("10 Actividades Voluntarias Que Puedes Realizar","Con tus Donativos Diana Combatirá el Linfomano","10 Actividades Voluntarias Que Puedes Realizar")
    private val details = arrayOf("Item one details","Item two details", "Item three details")
    private var images = intArrayOf(R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios,R.drawable.voluntarios)
    var filtro = ArrayList<String>()
    var items = ArrayList<Noticias>()
    //var itemsFiltrados = items


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterNoticias.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(items.size != 0){
            holder.itemTitle.text = items[position].getTitulo()
            holder.itemDescription.text = items[position].getDescipcion()
            holder.itemImage.setImageResource(images[position])
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
                bundle.putString("titulo", items[position].getTitulo())
                bundle.putString("details", items[position].getDescipcion())
                bundle.putInt("imageV", images[position])
                verMasFragment.arguments = bundle
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, verMasFragment).addToBackStack(null).commit()
            }
        })

    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDescription: TextView
        init{
            itemImage = itemView.findViewById(R.id.Image)
            itemTitle = itemView.findViewById(R.id.Title)
            itemDescription = itemView.findViewById(R.id.Description)
        }
    }

//    private fun filtrarItems(){
//        itemsFiltrados = items.filter{filtro.indexOf(it.getCategoria()) != -1} as ArrayList<Noticias>
//    }



}