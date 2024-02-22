package com.example.tarea3room_javierreyes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tarea3room_javierreyes.database.dao.DetailDao
import com.example.tarea3room_javierreyes.database.dao.ListDao
import com.example.tarea3room_javierreyes.database.entities.DetailEntity
import com.example.tarea3room_javierreyes.database.entities.ListEntity

@Database(entities = [DetailEntity::class, ListEntity::class], version = 1)
abstract class SuperheroDatabase : RoomDatabase (){
    abstract fun detailDao(): DetailDao
    abstract fun listDao(): ListDao
}


