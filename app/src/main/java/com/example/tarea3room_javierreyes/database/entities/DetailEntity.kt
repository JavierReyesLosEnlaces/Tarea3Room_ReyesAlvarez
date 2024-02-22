package com.example.tarea3room_javierreyes.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tarea3room_javierreyes.SuperheroApp.SuperHeroDetailResponse

@Entity (tableName = "SuperheroDetails")
data class DetailEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "intelligence") val intelligence: String?,
    @ColumnInfo(name = "strength") val strength: String?,
    @ColumnInfo(name = "speed") val speed: String?,
    @ColumnInfo(name = "durability") val durability: String?,
    @ColumnInfo(name = "power") val power: String?,
    @ColumnInfo(name = "combat") val combat: String?,
    @ColumnInfo(name = "fullName ") val fullName : String?,
    @ColumnInfo(name = "publisher ") val publisher : String?,
)
fun SuperHeroDetailResponse.toDatabase() = DetailEntity(
    intelligence = powerstats.intelligence,
    strength = powerstats.strength,
    speed = powerstats.speed,
    durability = powerstats.durability,
    power = powerstats.power,
    combat = powerstats.combat,
    fullName = biography.fullName,
    publisher = biography.publisher
)
