package com.example.caritasreto.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.caritasreto.R
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //Referencia los objetos que estamos utilizando
    private val homeFragment = Home()
    private val profileFragment = Profile()
//    private val filterFragment = filtros()
    private val loginFragment = Login()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(homeFragment)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(homeFragment)
                R.id.profile -> replaceFragment(loginFragment)
                //R.id.filtros -> replaceFragment(filterFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}