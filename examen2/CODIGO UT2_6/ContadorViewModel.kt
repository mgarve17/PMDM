package com.example.ut2_6.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel : ViewModel() {

    // LiveData privado modificable internamente y público de solo lectura
    private val _contador = MutableLiveData<Int>()
    val contador: LiveData<Int> = _contador

    // Función de lógica de negocio para incrementar el contador
    fun add() {
        val cont = _contador.value ?: 0
        _contador.value = cont + 1
    }
}