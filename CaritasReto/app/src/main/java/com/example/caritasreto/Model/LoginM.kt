package com.example.caritasreto.Model

class LoginM {
    var username: String = "prueba"
    var password: String = "prueba"

    fun verificador(s1: String, s2: String): Boolean {
        return s1 == username && s2 == password
    }
}