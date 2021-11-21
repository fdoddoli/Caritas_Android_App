package com.example.caritasreto.controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.example.caritasreto.R


class Filtros : Fragment() {

    //Definir variables de las imagenes del filtro
    lateinit var filterBancoAlimentos : ImageView
    lateinit var filterBancoMedicamentos : ImageView
    lateinit var filterBancoRopa : ImageView
    lateinit var filterMty : ImageView
    lateinit var filterParroquiales : ImageView
    lateinit var filterCasos : ImageView
    lateinit var filterEmergencias : ImageView
    lateinit var filterPosadasPeregrino : ImageView
    lateinit var filterPromHumana : ImageView
    lateinit var filterServSalud : ImageView
    lateinit var filterVoluntarios : ImageView

    //Definir variable para boton de aplicar
    lateinit var aplicarBtn : Button

    lateinit var myFragmentManager: FragmentManager

    //Definir arreglo que guardará los tags de noticias a desplegar
    val filtro = ArrayList<String>()

    companion object {
        @JvmStatic
        fun newInstance(datos: ArrayList<String>) = Filtros().apply {
            val args = Bundle().apply{
                putStringArrayList("datos", filtro)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragmentManager = parentFragmentManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filtros, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Asignar variables a sus respectivos componentes
        filterBancoAlimentos = view.findViewById(R.id.banco_alimentos)
        filterBancoMedicamentos = view.findViewById(R.id.banco_medicamentos)
        filterBancoRopa = view.findViewById(R.id.banco_ropa)
        filterMty = view.findViewById(R.id.caritas_mty)
        filterParroquiales = view.findViewById(R.id.parroquiales)
        filterCasos = view.findViewById(R.id.casos)
        filterEmergencias = view.findViewById(R.id.emrg_desastres)
        filterPosadasPeregrino = view.findViewById(R.id.posadas_peregrino)
        filterPromHumana = view.findViewById(R.id.prom_humana)
        filterServSalud = view.findViewById(R.id.serv_salud)
        filterVoluntarios = view.findViewById(R.id.voluntarios)

        aplicarBtn = view.findViewById(R.id.aplicarButton)

        assignClickListenersIcons()
        assignClickListeners()
    }

    private fun assignClickListenersIcons(){
        //Click Listeners para las Imagenes de Filtro
        filterBancoAlimentos.setOnClickListener{
            //Cambiar imagen
            filterBancoAlimentos.setImageResource(R.drawable.icono_1_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("banco_alimentos")
        }
        filterBancoMedicamentos.setOnClickListener{
            //Cambiar imagen
            filterBancoMedicamentos.setImageResource(R.drawable.icono_2_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("banco_medicamentos")
        }
        filterBancoRopa.setOnClickListener{
            //Cambiar imagen
            filterBancoRopa.setImageResource(R.drawable.icono_3_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("banco_ropa")
        }
        filterMty.setOnClickListener{
            //Cambiar imagen
            filterMty.setImageResource(R.drawable.icono_4_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("mty")
        }
        filterParroquiales.setOnClickListener{
            //Cambiar imagen
            filterParroquiales.setImageResource(R.drawable.icono_5_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("parroquiales")
        }
        filterCasos.setOnClickListener{
            //Cambiar imagen
            filterCasos.setImageResource(R.drawable.icono_6_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("casos")
        }
        filterEmergencias.setOnClickListener{
            //Cambiar imagen
            filterEmergencias.setImageResource(R.drawable.icono_7_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("emergencias")
        }
        filterPosadasPeregrino.setOnClickListener{
            //Cambiar imagen
            filterPosadasPeregrino.setImageResource(R.drawable.icono_8_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("posadas")
        }
        filterPromHumana.setOnClickListener{
            //Cambiar imagen
            filterPromHumana.setImageResource(R.drawable.icono_9_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("promocion_humana")
        }
        filterServSalud.setOnClickListener{
            //Cambiar imagen
            filterServSalud.setImageResource(R.drawable.icono_10_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("salud")
        }
        filterVoluntarios.setOnClickListener{
            //Cambiar imagen
            filterVoluntarios.setImageResource(R.drawable.icono_11_2)
            //Agregar categoría al arreglo de filtro
            filtro.add("voluntarios")
        }
    }

    private fun assignClickListeners(){
        //Cerrar filter y pasar datos
        aplicarBtn.setOnClickListener{
            val homeFragment = Home()
            val bundle = Bundle()
            bundle.putStringArrayList("datos", filtro)
            homeFragment.arguments = bundle
            myFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment).commit()
        }

    }



}