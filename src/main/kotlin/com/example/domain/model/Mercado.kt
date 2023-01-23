package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Mercado(
    val name: String,
    val dia: Dia

    )
