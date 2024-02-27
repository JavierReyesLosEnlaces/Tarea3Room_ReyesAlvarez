package com.example.tarea3room_javierreyes.SuperheroApp

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.tarea3room_javierreyes.SuperheroApp.SuperheroListActivity.Companion.EXTRA_ID
import com.example.tarea3room_javierreyes.database.SuperheroDatabase
import com.example.tarea3room_javierreyes.database.entities.DetailEntity
import com.example.tarea3room_javierreyes.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSuperheroBinding
    private lateinit var room: SuperheroDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        room = Room.databaseBuilder(this, SuperheroDatabase::class.java, "superheroes2").build()
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id.toInt())
    }

    private fun getSuperheroInformation(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = room.detailDao().selectAllSuperheroDetails(id)
            runOnUiThread { createUI(superheroDetail) }
        }
    }

    private fun createUI(superhero: DetailEntity) {
        Picasso.get().load(superhero.image).into(binding.ivSuperhero)
        binding.tvSuperheroName.text = superhero.name
        binding.tvSuperheroRealName.text = superhero.fullName
        binding.tvPublisher.text = superhero.publisher
        prepareStats(superhero)
    }

    private fun prepareStats(results: DetailEntity) {
        updateHeight(binding.viewIntelligence, results.intelligence)
        updateHeight(binding.viewStrength, results.strength)
        updateHeight(binding.viewSpeed, results.speed)
        updateHeight(binding.viewDurability, results.durability)
        updateHeight(binding.viewPower, results.power)
        updateHeight(binding.viewCombat, results.combat)
    }

    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        if(stat=="null"){params.height=pxToDp(0.toFloat())}
        else{params.height = pxToDp(stat.toFloat())}
        view.layoutParams = params
    }

    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}