package com.example.caritasreto.Model.Database

import kotlinx.serialization.Serializable

@Serializable
data class Donativo(val aportacion: Float, val donativo: String, val actividad: String)