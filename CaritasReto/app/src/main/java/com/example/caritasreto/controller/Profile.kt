package com.example.caritasreto.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.R

class Profile : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager ? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterDonativos.ViewHolder> ? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.profileRecyclerView)
        layoutManager = LinearLayoutManager(getActivity())
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapterDonativos()
        recyclerView.adapter = adapter

    }
}