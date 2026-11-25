package com.example.ut2_6.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GrupoAleatViewModel : ViewModel() {

    // Inicializamos la variable privada con una lista vacía
    private val _grupoAleatNumbers = MutableLiveData<List<Int>>(emptyList())
    val grupoAleatNumbers: LiveData<List<Int>> = _grupoAleatNumbers

    fun generateGrupoNumbers() {
        // Sobre un rango de 1 a 16, los desordena, toma los 4 primeros y los ordena
        _grupoAleatNumbers.value = (1..16).shuffled().take(4).sorted()
    }
}