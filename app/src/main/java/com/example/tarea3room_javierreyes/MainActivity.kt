package com.example.tarea3room_javierreyes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea3room_javierreyes.SuperheroApp.SuperheroItemResponse
import com.example.tarea3room_javierreyes.database.entities.DetailEntity

class MainActivity : AppCompatActivity() {

    private lateinit var room: SuperheroDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillDatabase()
    }

    fun SuperheroItemResponse.toDatabase() = DetailEntity(name = name, image = superheroImage.url)
    private fun fillDatabase() {
        TODO("Not yet implemented")
        // El código de searchByName, meterlo aquí
    }


}