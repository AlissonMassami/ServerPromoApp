package com.example.routes


import com.example.domain.model.ApiRequest
import com.example.domain.model.ApiRequestMercado
import com.example.domain.model.Endpoint
import com.example.domain.model.User
import com.example.domain.repository.MercadoDataSource
import com.example.domain.repository.UserDataSource
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*


fun Routing.consultaRoute(
    app: Application,
    mercadoDataSource: MercadoDataSource
) {
    post(Endpoint.ConsultaDia.path) {
        val request = call.receive<ApiRequestMercado>()
        if (request.dia.isNotEmpty() && request.tipoPromo.isNotEmpty()) {
            mercadoDataSource.getDiaPromo(request.dia,request.tipoPromo)
        } else {
            app.log.info("EMPTY TOKEN ID")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}

