package com.example.data.repository

import com.example.domain.model.Mercado
import com.example.domain.model.User
import com.example.domain.repository.MercadoDataSource
import com.example.domain.repository.UserDataSource
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.aggregate
import org.litote.kmongo.eq
import org.litote.kmongo.match
import org.litote.kmongo.setValue


class MercadoDataSourceImp(
    //versão do mongodb que suporta coroutines
    database: CoroutineDatabase
) : MercadoDataSource{
    private val mercados = database.getCollection<Mercado>()

    override suspend fun getDiaPromo(dia: String, tipo: String): Mercado {
        TODO("Not yet implemented")
    }

    override suspend fun salvarNovoMercado(mercado: Mercado): Boolean {
        val mercadoExistente = mercados.findOne(filter = Mercado::name eq mercado.name)
        return if (mercadoExistente == null) {
            mercados.insertOne(document = mercado).wasAcknowledged()
        } else {
            true
        }
    }

    override suspend fun getListaMercados(): List<Mercado> {
        return mercados.find().toList()

    }

    override suspend fun deleteUser(nomeMercado: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserInfo(userId: String, firstName: String, lastName: String): Boolean {
        TODO("Not yet implemented")
    }

}

