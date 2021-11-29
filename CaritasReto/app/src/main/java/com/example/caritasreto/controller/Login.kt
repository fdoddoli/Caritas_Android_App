package com.example.caritasreto.controller

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.caritasreto.R
import androidx.fragment.app.FragmentManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.caritasreto.Model.Database.Aportacion
import com.example.caritasreto.Model.Database.Donacion
import com.example.caritasreto.Model.Database.Donativo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONArray

class Login : Fragment(){

    lateinit var usernameET: EditText
    lateinit var passET: EditText
    lateinit var loginButton: Button
    lateinit var myFragmentManager: FragmentManager
    lateinit var msjInvalid: TextView

    private val ipAdd = "192.168.15.33"
    private val profileFragment = Profile()
    private var username : String = ""
    private var pass : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myFragmentManager = parentFragmentManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usernameET = view.findViewById(R.id.editTextTextEmailAddress)
        passET = view.findViewById((R.id.editTextPassword))
        loginButton = view.findViewById(R.id.loginbutton)
        msjInvalid = view.findViewById(R.id.msjInvalid)
        assignClickListeners()
    }


    private fun assignClickListeners(){
        loginButton.setOnClickListener{
            username = usernameET.text.toString()
            pass = passET.text.toString()

            val bundle = Bundle()
            val queue = Volley.newRequestQueue(requireContext())

            val donacionesRequest = StringRequest(Request.Method.GET,
                "http://$ipAdd:80/caritasdb/donaciones.php?user=$username",
                { response ->
                    val jsonArray = JSONArray(response)
                    bundle.putString("jsonDonaciones", jsonArray.toString())
                    profileFragment.arguments = bundle
                    myFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, profileFragment).commit()
                },
                { error ->
                    Log.d("Error", error.toString())

                })

            val donativosRequest = StringRequest(Request.Method.GET,
                "http://$ipAdd:80/caritasdb/donativos.php?user=$username",
                { response ->
                    val jsonArray = JSONArray(response)
                    bundle.putString("jsonDonativos", jsonArray.toString())
                },
                { error ->
                    Log.d("Error", error.toString())

                })

            val aportacionesRequest = StringRequest(Request.Method.GET,
                "http://$ipAdd:80/caritasdb/aportaciones.php?user=$username",
                { response ->
                    val jsonArray = JSONArray(response)
                    if (jsonArray.length() != 0) {
                        bundle.putString("jsonAportacion", jsonArray[0].toString())
                    }
                },
                { error ->
                    Log.d("Error", error.toString())

                })

            val loginRequest = StringRequest(Request.Method.GET,
                "http://$ipAdd:80/caritasdb/login.php?user=$username&pass=$pass",
                { response ->
                    val jsonArray = JSONArray(response)
                    if (jsonArray.length() != 0) {
                        setPrefs()
                        queue.add(aportacionesRequest)
                        queue.add(donativosRequest)
                        queue.add(donacionesRequest)
                    } else {
                        msjInvalid.setVisibility(View.VISIBLE)
                    }
                },
                { error ->
                    Log.d("Error", error.toString())

                })
            queue.add(loginRequest)
        }
    }

    private fun setPrefs(){
        val prefs = activity?.getSharedPreferences("prefs", AppCompatActivity.MODE_PRIVATE)
        val editor = prefs?.edit()
        editor?.apply {
            putString("UID", username)
            putString("IPADD", ipAdd)
        }
    }
}