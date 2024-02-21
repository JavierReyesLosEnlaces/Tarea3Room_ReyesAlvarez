package com.example.tarea3room_javierreyes.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tarea3room_javierreyes.database.entities.ListEntity

@Dao
interface DetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(lista: List<ListEntity>)

    @Query("DELETE FROM superdetail")
    suspend fun delete(listEnt: ListEntity)

    @Query("SELECT * FROM superdetail where `fullName ` LIKE :name")
    suspend fun getAll(name: String?): List<ListEntity>
}