package com.example.routes


import com.example.domain.model.ApiResponse
import com.example.domain.model.ApiRespostaLista
import com.example.domain.model.Endpoint
import com.example.domain.repository.MercadoDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Routing.listaMercadoRoute(
    app: Application,
    mercadoDataSource: MercadoDataSource
) {
    get(Endpoint.ListaMercados.path) {
        try {
            call.respond(
                message = ApiRespostaLista(
                    lista = mercadoDataSource.getListaMercados()
                ),
                status = HttpStatusCode.OK
            )
        } catch (e: Exception) {
            app.log.info("ERRO PEGAR LISTA DE MERCADOS: ${e.message}")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}