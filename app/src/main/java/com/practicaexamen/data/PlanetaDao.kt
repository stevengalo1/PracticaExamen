package com.practicaexamen.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.practicaexamen.model.Planeta


@Dao
interface PlanetaDao {
    @Query("select * from ESTADO")
    fun getAllData(): LiveData<List<Planeta>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlaneta(planeta: Planeta)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updatePlaneta(planeta: Planeta)

    @Delete
    suspend fun deletePlaneta(planeta: Planeta)
}