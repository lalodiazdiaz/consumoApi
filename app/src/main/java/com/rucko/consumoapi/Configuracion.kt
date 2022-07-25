package com.rucko.consumoapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Configuracion {

    val URLBase = "https://jsonplaceholder.typicode.com/"

    fun obtenerConfiguracionRetrofit():ApiWeb{
        var objRetrofit = Retrofit.Builder()
            .baseUrl(URLBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiWeb= objRetrofit.create(ApiWeb::class.java)

        return apiWeb
    }
}