package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResposta(
    val success: Boolean,
    val mercado : Mercado? = null,
    val message: String? = null
)
