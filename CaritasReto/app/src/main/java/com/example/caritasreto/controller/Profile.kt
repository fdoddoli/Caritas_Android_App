package com.example.caritasreto.controller

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.caritasreto.Model.Database.Aportacion
import com.example.caritasreto.Model.Database.Donacion
import com.example.caritasreto.Model.Database.Donativo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONArray
import com.example.caritasreto.R

class Profile : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager ? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterDonativos.ViewHolder> ? = null
    lateinit var recyclerView: RecyclerView
    lateinit var aportacion: Aportacion
    lateinit var donativos : ArrayList<Donativo>
    lateinit var donaciones: ArrayList<Donacion>
    lateinit var nombre : TextView
    lateinit var numDonaciones: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val args = this.arguments

        aportacion = Json.decodeFromString(args?.get("jsonAportacion").toString())
        println(args?.get("jsonDonativos"))
        //donativos = arrayListOf()
        donativos = Json.decodeFromString(args?.get("jsonDonativos").toString())
        donaciones = Json.decodeFromString(args?.get("jsonDonaciones").toString())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assignIds(view)

        nombre.text = aportacion.nombre_completo
        numDonaciones.text = aportacion.cantidad_donaciones.toString()
    }

    fun assignIds(view: View){
        nombre = view.findViewById(R.id.nombre)
        numDonaciones = view.findViewById(R.id.numDonaciones)

        recyclerView = view.findViewById(R.id.profileRecyclerView)
        adapter = RecyclerAdapterDonativos(donativos)
        recyclerView.adapter = adapter
        layoutManager = LinearLayoutManager(getActivity())
        recyclerView.layoutManager = layoutManager
    }
}