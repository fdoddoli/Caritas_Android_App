package com.example.caritasreto.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.caritasreto.R
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.caritasreto.Model.LoginM


class Login : Fragment(){

    lateinit var passwordET: EditText
    lateinit var userET: EditText
    lateinit var loginButton: Button
    lateinit var loginM: LoginM
    lateinit var myFragmentManager: FragmentManager
    lateinit var msjInvalid: TextView

    private val profileFragment = Profile()

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
        userET = view.findViewById(R.id.editTextTextEmailAddress)
        passwordET = view.findViewById((R.id.editTextPassword))
        loginButton = view.findViewById(R.id.loginbutton)
        msjInvalid = view.findViewById(R.id.msjInvalid)
        loginM = LoginM()
        assignClickListeners()
    }


    private fun assignClickListeners(){
        loginButton.setOnClickListener{
            if (loginM.verificador(userET.text.toString(), passwordET.text.toString())) {
                myFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, profileFragment).commit()
            }
            else{
                msjInvalid.setVisibility(View.VISIBLE)
            }
        }
    }

}