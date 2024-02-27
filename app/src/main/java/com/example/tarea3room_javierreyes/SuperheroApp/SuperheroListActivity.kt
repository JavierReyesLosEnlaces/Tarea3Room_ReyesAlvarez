package com.example.tarea3room_javierreyes.SuperheroApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.tarea3room_javierreyes.database.SuperheroDatabase
import com.example.tarea3room_javierreyes.database.entities.ListEntity
import com.example.tarea3room_javierreyes.database.entities.toDatabase
import com.example.tarea3room_javierreyes.databinding.ActivitySuperheroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroListActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivitySuperheroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var room: SuperheroDatabase
    private lateinit var adapter: SuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        room = Room.databaseBuilder(this, SuperheroDatabase::class.java, "superheroes2").build()
        retrofit = getRetrofit()
        llenarDB()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = SuperheroAdapter { superheroId ->  navigateToDetail(superheroId) }
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun llenarDB() {

        CoroutineScope(Dispatchers.IO).launch {
            val ListResponse: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperheroes()
            val DetailResponse : Response<SuperHeroDetailResponse> =  retrofit.create(ApiService::class.java).getSuperheroDetail()

            // 1. LIST RESPONSE
            if (ListResponse.isSuccessful) {
                val response: SuperHeroDataResponse? = ListResponse.body()
                if (response != null ) {

                    // Primero eliminamos todos los datos de list response
                    room.listDao().deleteAll()

                    // Después insertamos todos los datos
                    room.listDao().insertAll(response.results.map { it.toDatabase()})
                    Log.i("insertado", "success")
                } else {
                    Log.i("Resultado", "No se encuentran resultados")
                }
            } else {
                Log.i("Consulta", "No funciona :(")
            }
            // 1. DETAIL RESPONSE
            if (DetailResponse.isSuccessful) {
                val response: SuperHeroDetailResponse? = DetailResponse.body()
                if (response != null ) {

                    // Primero eliminamos todos los datos de list response
                    room.detailDao().deleteAllSuperheroDetails()

                    // Después insertamos todos los datos
                    room.detailDao().insertAllSuperheroDetails(response.resultados.map { it.toDatabase() })
                    Log.i("insertado", "success")
                } else {
                    Log.i("Resultado", "No se encuentran resultados")
                }
            } else {
                Log.i("Consulta", "No funciona :(")
            }
        }
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: List<ListEntity> = room.listDao().getAll("%$query%")

            if (myResponse!= null) {
                Log.i("Consulta", "Funciona :)")
                runOnUiThread {
                    adapter.updateList(myResponse)
                    binding.progressBar.isVisible = false
                }
            } else {
                Log.i("Consulta", "No funciona :(")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

}