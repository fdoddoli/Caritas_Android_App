package com.example.caritasreto.Model

class Donaciones {
    lateinit var amount: String
    lateinit var frequency: String
    lateinit var department: String
    lateinit var status: String


    fun getCantidad(): String{
        return amount
    }

    fun getFrecuencia(): String{
        return frequency
    }

    fun getDepartamento(): String{
        return department
    }

    fun getEstatus(): String{
        return status
    }
}