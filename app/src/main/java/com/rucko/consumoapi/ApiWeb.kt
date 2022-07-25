package com.rucko.consumoapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiWeb {

    @GET("{parametro}")
    fun recuperarComentarios(@Path("parametro") parametro:String):Call<ArrayList<Comentario>>
}