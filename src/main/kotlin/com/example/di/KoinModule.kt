package com.example.di

import com.example.data.repository.MercadoDataSourceImp
import com.example.data.repository.UserDataSourceImpl
import com.example.domain.repository.MercadoDataSource
import com.example.domain.repository.UserDataSource
import com.example.util.Constants.DATABASE_NAME
import org.koin.dsl.module

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val koinModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase(DATABASE_NAME)
    }
    single<MercadoDataSource> {
        MercadoDataSourceImp(get())
    }
}