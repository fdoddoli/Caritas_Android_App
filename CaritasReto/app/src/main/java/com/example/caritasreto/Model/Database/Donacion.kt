package com.example.caritasreto.Model.Database

import kotlinx.serialization.Serializable

@Serializable
data class Donacion(val fecha: String, val donativo: String, val aportacion: Float)