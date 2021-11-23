package com.example.caritasreto.controller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caritasreto.R

class VerMas : Fragment() {

    lateinit var tituloTemp: String
    lateinit var detailsTemp: String
    lateinit var titulo: TextView
    lateinit var details: TextView
    lateinit var imagesTemp: IntArray
    lateinit var backBtn: ImageButton
    lateinit var myFragmentManager: FragmentManager
    var imageV = 0
    lateinit var image: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragmentManager = parentFragmentManager
    }

    // Lectura de los datos
    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("titulo")?.let{
            tituloTemp = it
        }
        arguments?.getString("details")?.let{
            detailsTemp = it
        }
        arguments?.getInt("imageV")?.let{
            imageV = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ver_mas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titulo = view.findViewById(R.id.titulo_verMas)
        details = view.findViewById(R.id.details_verMas)
        image = view.findViewById(R.id.image_verMas)
        titulo.setText(tituloTemp)
        details.setText(detailsTemp)
        image.setImageResource(imageV)
        backBtn = view.findViewById(R.id.backBtnVerMas)
        assignClickListeners()
    }

    fun assignClickListeners(){
        val homeFragment = Home()
        backBtn.setOnClickListener{
            myFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment).commit()
        }
    }
}