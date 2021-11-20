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

class RecyclerAdapterNoticias: RecyclerView.Adapter<RecyclerAdapterNoticias.ViewHolder>(){
    private val titles = arrayOf("10 Actividades Voluntarias Que Puedes Realizar","Con tus Donativos Diana Combatirá el Linfomano")
    private val details = arrayOf("Item one details","Item two details")
    private var images = intArrayOf(R.drawable.voluntarios,R.drawable.voluntarios )
    var filtro = ArrayList<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterNoticias.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDescription.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDescription: TextView
        var verMas: TextView
        init{
            itemImage = itemView.findViewById(R.id.Image)
            itemTitle = itemView.findViewById(R.id.Title)
            itemDescription = itemView.findViewById(R.id.Description)
            verMas = itemView.findViewById(R.id.verMas)

            verMas.setOnClickListener{
                val position : Int = adapterPosition
                Toast.makeText(itemView.context, "POSITION: ${position}", Toast.LENGTH_LONG).show()
            }
        }
    }


}