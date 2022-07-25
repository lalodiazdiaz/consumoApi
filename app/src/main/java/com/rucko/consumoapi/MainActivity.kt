package com.rucko.consumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var apiWeb: ApiWeb
    var listaComentarios=ArrayList<Comentario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiWeb = Configuracion.obtenerConfiguracionRetrofit()
        consumirServicioGet()
    }

fun consumirServicioGet(){
    var callRespuesta = apiWeb.recuperarComentarios("comments")
    callRespuesta.enqueue(object: Callback<ArrayList<Comentario>>{
        override fun onResponse(
            call: Call<ArrayList<Comentario>>,
            response: Response<ArrayList<Comentario>>
        ) {
            if (response.isSuccessful){
                for (comentario in response.body()!!){
                    Log.d("Mensaje","${comentario.id}")
                    Log.d("Mensaje","${comentario.name}")
                    Log.d("Mensaje","${comentario.email}")
                    Log.d("Mensaje","${comentario.body}")
                    listaComentarios.add(comentario)
                }
            }
        }

        override fun onFailure(call: Call<ArrayList<Comentario>>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })
}
}