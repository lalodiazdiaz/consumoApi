package com.rucko.consumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        var id = intent.getIntExtra("Id",0)
        var name =intent.getStringExtra("Name")
        var emial =intent.getStringExtra("Email")
        var body =intent.getStringExtra("Body")

        txtDetalleId.text= id.toString()
        txtDetalleName.text= name
        txtDetalleEmail.text= emial
        txtDetalleBody.text=body
    }
}