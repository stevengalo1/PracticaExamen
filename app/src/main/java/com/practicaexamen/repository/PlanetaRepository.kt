package com.practicaexamen.repository

import androidx.lifecycle.LiveData
import com.practicaexamen.data.PlanetaDao
import com.practicaexamen.model.Planeta

class PlanetaRepository(private val planetaDao: PlanetaDao) {
    val getAllData : LiveData<List<Planeta>> = planetaDao.getAllData()

    suspend fun addPlaneta(planeta: Planeta){
        planetaDao.addPlaneta(planeta)
    }

    suspend fun updatePlaneta(planeta: Planeta){
        planetaDao.updatePlaneta(planeta)
    }

    suspend fun deletePlaneta(planeta: Planeta){
        planetaDao.deletePlaneta(planeta)
    }
}