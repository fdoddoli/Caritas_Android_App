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

class RecyclerAdapterNoticias: RecyclerView.Adapter<RecyclerAdapterNoticias.ViewHolder>(){
    private val titles = arrayOf("10 Actividades Voluntarias Que Puedes Realizar","Con tus Donativos Diana Combatirá el Linfomano")
    private val details = arrayOf("Item one details","Item two details")
    private var images = intArrayOf(R.drawable.voluntarios,R.drawable.icono_1 )
    var filtro = ArrayList<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterNoticias.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDescription.text = details[position]
        holder.itemImage.setImageResource(images[position])

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
                bundle.putString("titulo", titles[position])
                bundle.putString("details", details[position])
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
        var verMas: TextView
        init{
            itemImage = itemView.findViewById(R.id.Image)
            itemTitle = itemView.findViewById(R.id.Title)
            itemDescription = itemView.findViewById(R.id.Description)
            verMas = itemView.findViewById(R.id.verMas)

            verMas.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "POSITION: ${position}", Toast.LENGTH_LONG).show()
            }
        }
    }



}