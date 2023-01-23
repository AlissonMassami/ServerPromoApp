package com.example.domain.model


//cada objeto representa um endpoint do server
sealed class Endpoint(val path: String) {
    object Root: Endpoint(path = "/")
    object ListaMercados: Endpoint(path = "/lista_mercados")
    object ConsultaDia: Endpoint(path = "/consulta_dia")
    object Unauthorized: Endpoint(path = "/unauthorized")
    object NovoMercado: Endpoint(path = "/novo_mercado")

}
