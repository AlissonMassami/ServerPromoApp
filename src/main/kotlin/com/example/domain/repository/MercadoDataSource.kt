package com.example.domain.repository

import com.example.domain.model.Mercado
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface MercadoDataSource {
    suspend fun getDiaPromo(dia: String, tipo: String): Mercado?
    suspend fun salvarNovoMercado(mercado: Mercado): Boolean
    suspend fun getListaMercados(): List<Mercado>
    suspend fun deleteUser(nomeMercado: String): Boolean
    suspend fun updateUserInfo(
        userId: String,
        firstName: String,
        lastName: String
    ): Boolean
}