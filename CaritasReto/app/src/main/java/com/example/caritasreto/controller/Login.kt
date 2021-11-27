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
import com.example.caritasreto.R
import androidx.fragment.app.FragmentManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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
            val queue = Volley.newRequestQueue(requireContext())
            val loginRequest = StringRequest(Request.Method.GET,
                "http://$ipAdd:80/caritasdb/login.php?user=$username&pass=$pass",
                { response ->
                    val jsonArray = JSONArray(response)
                    if (jsonArray.length() != 0) {
                        setUid()
                        myFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, profileFragment).commit()
                    } else {
                        println("INVALID")
                        println(username)
                        println(pass)
                        println(ipAdd)
                        msjInvalid.setVisibility(View.VISIBLE)
                    }
                },
                { error ->
                    Log.d("tag", error.toString())

                })
            queue.add(loginRequest)
        }
    }

    private fun setUid(){
        val prefs = activity?.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = prefs?.edit()
        editor?.apply {
            putString("UID", username)
        }
    }
}