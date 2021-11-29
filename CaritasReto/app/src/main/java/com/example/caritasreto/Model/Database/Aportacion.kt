package com.example.caritasreto.Model.Database

import kotlinx.serialization.Serializable

@Serializable
data class Aportacion(val nombre_completo: String, val cantidad_donaciones: Int, val total_aportaciones: Float)