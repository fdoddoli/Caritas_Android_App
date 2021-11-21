package com.example.caritasreto.controller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.R

class Home : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager ? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterNoticias.ViewHolder> ? = null
    lateinit var recyclerView: RecyclerView
    lateinit var btnFilter: Button
    lateinit var myFragmentManager: FragmentManager
    private var recyclerAdapterNoticias = RecyclerAdapterNoticias()

    var departamentos = (arrayListOf<String>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragmentManager = parentFragmentManager
    }

    // Lectura de los datos
    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getStringArrayList("datos")?.let{
            departamentos = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        btnFilter = view.findViewById(R.id.filter_btn)
        layoutManager = LinearLayoutManager(getActivity())
        recyclerView.layoutManager = layoutManager

        recyclerAdapterNoticias.filtro = departamentos

        adapter = recyclerAdapterNoticias
        recyclerView.adapter = adapter

        assignClickListeners()

    }

    private fun assignClickListeners(){
        val filterFragment = Filtros()
        btnFilter.setOnClickListener{
            myFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, filterFragment).commit()
        }
    }

}