package com.example.tarea3room_javierreyes.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tarea3room_javierreyes.database.entities.ListEntity

@Dao
interface ListDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(lista: List<ListEntity>)

    @Query ("DELETE FROM SuperheroList")
    suspend fun deleteAll()

    @Query("SELECT * FROM SuperheroList where name LIKE :name")
    suspend fun getAll(name: String?): List<ListEntity>
}
