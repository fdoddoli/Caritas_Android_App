package com.example.caritasreto.controller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.Model.Database.Aportacion
import com.example.caritasreto.Model.Database.Donativo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import com.example.caritasreto.R

class Profile : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager ? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterDonativos.ViewHolder> ? = null
    lateinit var recyclerView: RecyclerView
    lateinit var aportacion: Aportacion
    lateinit var donativos : ArrayList<Donativo>
    lateinit var nombre : TextView
    lateinit var numDonaciones: TextView
    lateinit var aportacionTotal: TextView
    lateinit var btnLogoout : ImageView
    lateinit var myFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragmentManager = parentFragmentManager

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val args = this.arguments

        aportacion = Json.decodeFromString(args?.get("jsonAportacion").toString())
        donativos = Json.decodeFromString(args?.get("jsonDonativos").toString())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assignIds(view)
        assignListeners()

        println(activity?.getSharedPreferences("prefs", Context.MODE_PRIVATE)?.getBoolean("LOGGEDIN", false))

        nombre.text = aportacion.nombre_completo
        numDonaciones.text = aportacion.cantidad_donaciones.toString()
        aportacionTotal.text = aportacion.total_aportaciones.toString() + " MXN"
    }

    fun assignIds(view: View){
        nombre = view.findViewById(R.id.nombre)
        numDonaciones = view.findViewById(R.id.numDonaciones)
        aportacionTotal = view.findViewById(R.id.aportacionTotal)
        btnLogoout = view.findViewById(R.id.logout)

        recyclerView = view.findViewById(R.id.profileRecyclerView)
        adapter = RecyclerAdapterDonativos(donativos)
        layoutManager = LinearLayoutManager(getActivity())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    fun assignListeners(){
        btnLogoout.setOnClickListener {
            myFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Login()).commit()
        }
    }
}