package com.practicaexamen.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.practicaexamen.data.PlanetaDatabase
import com.practicaexamen.model.Planeta
import com.practicaexamen.repository.PlanetaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData : LiveData<List<Planeta>>
    private val repository: PlanetaRepository
    init{
        val planetaDao = PlanetaDatabase.getDatabase(application).planetaDao()
        repository= PlanetaRepository(planetaDao)
        getAllData= repository.getAllData
    }

    fun addPlaneta(planeta: Planeta){
        viewModelScope.launch(Dispatchers.IO) {repository.addPlaneta(planeta)}
    }

    fun updatePlaneta(planeta: Planeta){
        viewModelScope.launch(Dispatchers.IO) {repository.updatePlaneta(planeta)}
    }

    fun deletePlaneta(planeta: Planeta){
        viewModelScope.launch(Dispatchers.IO) {repository.deletePlaneta(planeta)}
    }
}