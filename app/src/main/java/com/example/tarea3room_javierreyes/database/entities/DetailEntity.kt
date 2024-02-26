package com.example.tarea3room_javierreyes.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tarea3room_javierreyes.SuperheroApp.DetailedIdResponse
import com.example.tarea3room_javierreyes.SuperheroApp.SuperHeroDetailResponse

@Entity (tableName = "SuperheroDetails")
data class DetailEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "intelligence") val intelligence: String,
    @ColumnInfo(name = "strength") val strength: String,
    @ColumnInfo(name = "speed") val speed: String,
    @ColumnInfo(name = "durability") val durability: String,
    @ColumnInfo(name = "power") val power: String,
    @ColumnInfo(name = "combat") val combat: String,
    @ColumnInfo(name = "fullName ") val fullName : String,
    @ColumnInfo(name = "publisher ") val publisher : String,
    @ColumnInfo(name = "image ") val image : String,
)
fun DetailedIdResponse.toDatabase() = DetailEntity(
    name = name,
    intelligence = results.intelligence,
    strength = results.strength,
    speed = results.speed,
    durability = results.durability,
    power = results.power,
    combat = results.combat,
    fullName = biography.fullName,
    publisher = biography.publisher,
    image = image.url
)
