package com.example.caritasreto.controller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.caritasreto.R
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.serialization.descriptors.PrimitiveKind

class MainActivity : AppCompatActivity() {
    private val homeFragment = Home()
    private val profileFragment = Profile()
    private val loginFragment = Login()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(homeFragment)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnItemSelectedListener {
            val session = checkLogin()
            println(session)
            when(it.itemId){
                R.id.home -> replaceFragment(homeFragment)
                R.id.profile -> if(session){
                    replaceFragment(profileFragment)
                }
                else{
                    replaceFragment(loginFragment)
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun checkLogin() : Boolean{
        return getSharedPreferences("prefs", Context.MODE_PRIVATE).getBoolean("LOGGEDIN", false)
    }
}