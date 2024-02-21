package com.example.tarea3room_javierreyes.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tarea3room_javierreyes.SuperheroApp.SuperheroItemResponse

@Entity(tableName = "superlist")
data class ListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String
)

fun SuperheroItemResponse.toDatabase() = ListEntity(
    name = name,
    image = superheroImage.url
)