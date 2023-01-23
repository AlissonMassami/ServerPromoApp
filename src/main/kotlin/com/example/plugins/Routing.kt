package com.example.plugins

import com.example.domain.repository.MercadoDataSource
import com.example.domain.repository.UserDataSource
import com.example.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    routing {
        val mercadoDataSource : MercadoDataSource by inject(MercadoDataSource::class.java)
        rootRoute()
        consultaRoute(application, mercadoDataSource)
        listaMercadoRoute(application, mercadoDataSource)
        novoMercadoRoute(application, mercadoDataSource)
        unauthorizedRoute()
    }
}