package com.example.tarea3room_javierreyes.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tarea3room_javierreyes.database.entities.DetailEntity

@Dao
interface DetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(lista: List<DetailEntity>)

    @Query("DELETE FROM SuperheroDetails")
    suspend fun deleteAll()

    @Query("SELECT * FROM SuperheroDetails where `fullName ` LIKE :name")
    suspend fun getAll(name: String?): List<DetailEntity>
}