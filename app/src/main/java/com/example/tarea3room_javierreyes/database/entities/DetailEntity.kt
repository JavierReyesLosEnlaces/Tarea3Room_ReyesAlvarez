package com.example.tarea3room_javierreyes.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DetailEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "intelligence") val intelligence: String?,
    @ColumnInfo(name = "strength") val strength: String?,
    @ColumnInfo(name = "speed") val speed: String?,
    @ColumnInfo(name = "durability") val durability: String?,
    @ColumnInfo(name = "power") val power: String?,
    @ColumnInfo(name = "combat") val combat: String?,
    @ColumnInfo(name = "fullName ") val fullName : String?,
    @ColumnInfo(name = "publisher ") val publisher : String?,
)