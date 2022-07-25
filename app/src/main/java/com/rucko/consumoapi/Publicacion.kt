package com.rucko.consumoapi

import com.google.gson.annotations.SerializedName

data class Publicacion (

    @SerializedName("id") var id:Int,
    @SerializedName("title") var title:String,
    @SerializedName("userId") var userId:Int,
    @SerializedName("body") var body:String,
        )