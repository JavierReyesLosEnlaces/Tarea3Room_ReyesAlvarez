package com.example.tarea3room_javierreyes.SuperheroApp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val results: List<SuperheroItemResponse>
)
data class SuperheroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage:SuperheroImageResponse
)
data class SuperheroImageResponse(@SerializedName("url") val url:String)
