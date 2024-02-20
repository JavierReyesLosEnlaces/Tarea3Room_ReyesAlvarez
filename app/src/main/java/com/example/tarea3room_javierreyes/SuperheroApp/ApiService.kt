package com.example.tarea3room_javierreyes.SuperheroApp

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api/10229233666327556/search/sp")
    suspend fun getSuperheroes(): Response<SuperHeroDataResponse>

    @GET("/api/10229233666327556/search/sp")
    suspend fun getSuperheroDetail(): Response<SuperHeroDetailResponse>
}