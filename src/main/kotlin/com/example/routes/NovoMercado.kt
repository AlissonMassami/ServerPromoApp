package com.example.routes


import com.example.domain.model.*
import com.example.domain.repository.MercadoDataSource
import com.example.domain.repository.UserDataSource
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*


fun Routing.novoMercadoRoute(
    app: Application,
    mercadoDataSource: MercadoDataSource
) {
    post(Endpoint.NovoMercado.path) {
        val request = call.receive<Mercado>()
        if (request.name.isNotEmpty()) {
            salvarMercadoToDatabase(app,request, mercadoDataSource)

        } else {
            app.log.info("EMPTY TOKEN ID")
            call.respondRedirect(Endpoint.Unauthorized.path)
        }
    }
}
private suspend fun PipelineContext<Unit, ApplicationCall>.salvarMercadoToDatabase(
    app: Application,
    request: Mercado,
    mercadoDataSource: MercadoDataSource
) {

    val mercado =  Mercado(
        name= request.name,
        dia = request.dia
//        domingo= request.domingo,
//        segunda= request.segunda,
//        terca= request.terca,
//        quarta= request.quarta,
//        quinta= request.quinta,
//        sexta= request.sexta,
//        sabado= request.sabado,
    )
    val response = mercadoDataSource.salvarNovoMercado(mercado)
    if (response) {
        app.log.info("MERCADO SALVO COM SUCESSO")
    } else {
        app.log.info("ERRO AO SALVAR MERCADO")
        call.respondRedirect(Endpoint.Unauthorized.path)
    }
}
