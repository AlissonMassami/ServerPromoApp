package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiRequestMercado(
    val dia: String,
    val tipoPromo: String
)
