package com.example.caritasreto.Model.Database

import kotlinx.serialization.Serializable

@Serializable
data class Donativo(val fecha: String, val donativo: String, val aportacion: Float, val actividad: String)