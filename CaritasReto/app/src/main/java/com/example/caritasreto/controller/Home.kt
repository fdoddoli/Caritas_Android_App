package com.example.caritasreto.controller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caritasreto.R
import java.io.IOException
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.HttpURLConnection
import java.net.URL
import android.os.AsyncTask
import android.util.Log
import com.example.caritasreto.Model.Noticias
import com.example.caritasreto.Model.RssParser


class Home : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager ? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterNoticias.ViewHolder> ? = null
    lateinit var recyclerView: RecyclerView
    lateinit var btnFilter: Button
    lateinit var myFragmentManager: FragmentManager
    private var recyclerAdapterNoticias = RecyclerAdapterNoticias()
    var listaFiltrada = arrayListOf<Noticias>()

    //RSS
    val RSS_FEED_LINK = "https://www.caritas.org.mx/feed/";
    var rssItems = ArrayList<Noticias>()


    var departamentos = (arrayListOf<String>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragmentManager = parentFragmentManager
    }

    // Lectura de categorias para filtrar
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
        if(!listaFiltrada.isEmpty()) {
            Log.d("datos-filtrados", listaFiltrada[0].title)
        }
        if(listaFiltrada.isEmpty()) {
            Log.d("datos-filtrados", "Esta vacia")
        }
        recyclerView.layoutManager = layoutManager
        if(!listaFiltrada.isEmpty()) {
            Log.d("datos-filtrados", listaFiltrada[0].title)
        }
        if(rssItems.isEmpty()){
            recyclerAdapterNoticias.items = rssItems //Pasarle a recyclerAdapterNoticias los rssItems
            Log.d("tamaño", rssItems.size.toString())
            //RSS
            val url = URL(RSS_FEED_LINK)
            RssFeedFetcher(this).execute(url)

        }
        adapter = recyclerAdapterNoticias
        recyclerView.adapter = adapter
        recyclerAdapterNoticias.filtro = departamentos
        listaFiltrada = filtrado(departamentos, rssItems)
        assignClickListeners()

    }

    private fun assignClickListeners(){
        val filterFragment = Filtros()
        btnFilter.setOnClickListener{
            myFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, filterFragment).commit()
        }
    }

    fun updateRV(rssItemsL: List<Noticias>) {
        if (rssItemsL != null && !rssItemsL.isEmpty()) {
            rssItems.addAll(rssItemsL)
            adapter?.notifyDataSetChanged()
        }
    }

    class RssFeedFetcher(val context: Home) : AsyncTask<URL, Void, List<Noticias>>() {
        val reference = WeakReference(context)
        private var stream: InputStream? = null;
        override fun doInBackground(vararg params: URL?): List<Noticias>? {
            val connect = params[0]?.openConnection() as HttpURLConnection
            connect.readTimeout = 8000
            connect.connectTimeout = 8000
            connect.requestMethod = "GET"
            connect.connect();
            val responseCode: Int = connect.responseCode;
            var rssItems: List<Noticias>? = null
            if (responseCode == 200) {
                stream = connect.inputStream;
                try {
                    val parser = RssParser()
                    rssItems = parser.parse(stream!!)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return rssItems
        }
        override fun onPostExecute(result: List<Noticias>?) {
            super.onPostExecute(result)
            if (result != null && !result.isEmpty()) {
                reference.get()?.updateRV(result)
            }
        }
    }
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: Noticias?)
    }
    fun filtrado(lista1: ArrayList<String>, lista2: ArrayList<Noticias>): ArrayList<Noticias>{
        var lista3: ArrayList<Noticias> = arrayListOf()
        Log.d("tag3", "Si entro")
        for (elements1 in lista1){
            Log.d("tag4", elements1)
            for (elements2 in lista2){
                Log.d("tag5", lista2.size.toString())
                if (elements1 == elements2.category){
                    Log.d("tag", elements1)
                    Log.d("tag2", elements2.category)
                    lista3.add(elements2)
                }
            }
        }
        return lista3
    }
}