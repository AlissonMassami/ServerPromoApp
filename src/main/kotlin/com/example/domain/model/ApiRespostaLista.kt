package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiRespostaLista(
    val lista: List<Mercado>
)
