package com.rucko.consumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
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
        miRecycler.apply {
            setHasFixedSize(true)
        }
      consumirServicioGet()
       // consumirServicioPost()
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



                var miMAnager = LinearLayoutManager(applicationContext)
                var miAdaptador = MyAdapter(listaComentarios)
                miRecycler.layoutManager= miMAnager
                miRecycler.adapter=miAdaptador
            }
        }

        override fun onFailure(call: Call<ArrayList<Comentario>>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })
}


    fun consumirServicioPost() {
    var publicacion = Publicacion(0,"Super post",5000,"Cuerpo del super post")
        var callRespuesta = apiWeb.insertarPublicacion(publicacion)
        callRespuesta.enqueue(object :Callback<Publicacion>{
            override fun onResponse(call: Call<Publicacion>, response: Response<Publicacion>) {
               if (response.isSuccessful){
                   var nuevoPost:Publicacion? = response.body()
                   var mensaje = "Post creado: ${nuevoPost!!.id}. Titulo: ${nuevoPost.title}. Body: ${nuevoPost.body}"
                   Toast.makeText(applicationContext,mensaje,Toast.LENGTH_LONG).show()
               }
            }

            override fun onFailure(call: Call<Publicacion>, t: Throwable) {
             Toast.makeText(applicationContext,"Fallo ${t.toString()}",Toast.LENGTH_SHORT).show()
            }

        })
    }
}