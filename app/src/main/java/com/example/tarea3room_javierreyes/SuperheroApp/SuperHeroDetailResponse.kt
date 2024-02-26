package com.example.tarea3room_javierreyes.SuperheroApp

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailResponse(
    @SerializedName("results") val resultados: List<DetailedIdResponse>,
)

data class  DetailedIdResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: Powerstats,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography") val biography:Biography,
    @SerializedName("appearance") val appearance:Appearance
)

data class Powerstats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String,
)


data class SuperheroImageDetailResponse(@SerializedName("url") val url:String)

data class Biography(
    @SerializedName("full-name") val fullName:String,
    @SerializedName("publisher") val publisher:String,
    @SerializedName("place-of-birth") val birthplace:String,
    @SerializedName("first-appearance") val starting:String,
    @SerializedName("aliases") val aliases:Array<String>
)

data class Appearance(
    @SerializedName("race") val race:String,
    @SerializedName("height") val height:Array<String>,
    @SerializedName("weight") val weight:Array<String>
)


