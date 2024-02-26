package com.example.tarea3room_javierreyes.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tarea3room_javierreyes.database.entities.DetailEntity

@Dao
interface DetailDao {
    @Query("SELECT * FROM SuperheroDetails where id LIKE :name")
    suspend fun selectAllSuperheroDetails(name: Int?): DetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSuperheroDetails(lista: List<DetailEntity>)

    @Query("DELETE FROM SuperheroDetails")
    suspend fun deleteAllSuperheroDetails()

}