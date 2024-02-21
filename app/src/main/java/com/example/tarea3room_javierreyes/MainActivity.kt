package com.example.tarea3room_javierreyes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.tarea3room_javierreyes.SuperheroApp.ApiService
import com.example.tarea3room_javierreyes.SuperheroApp.SuperHeroDataResponse
import com.example.tarea3room_javierreyes.database.SuperheroDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var room: SuperheroDatabase
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llenarDB()
        fillDatabase()
        room = Room.databaseBuilder(this, SuperheroDatabase::class.java, "superheroes").build()

    }

    private fun llenarDB() {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes()
            val superheroDetailResponse =  retrofit.create(ApiService::class.java).getSuperheroDetail()
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
            } else {
                Log.i("Consulta", "No funciona :(")
            }


        }
    }

    private fun insertAll() {
        TODO("Not yet implemented")
    }

    private fun deleteAll() {
        TODO("Not yet implemented")
    }

    private fun fillDatabase() {
        TODO("Not yet implemented")
        // El código de searchByName, meterlo aquí
    }


}