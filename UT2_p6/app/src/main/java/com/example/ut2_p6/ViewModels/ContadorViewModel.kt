package com.example.ut2_p6.ViewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ContadorViewModel : ViewModel() {

    private val _contador = MutableLiveData<Int>()
    val contador: LiveData<Int> = _contador

    fun add(){

        val cont = _contador.value ?: 0
        _contador.value = cont + 1
    }

}