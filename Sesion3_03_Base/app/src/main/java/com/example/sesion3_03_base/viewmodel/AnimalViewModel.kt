package com.example.sesion3_03_base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sesion3_03_base.model.Animal

class AnimalViewModel : ViewModel(){

    private val _animal = MutableLiveData<Animal?>(

        Animal(

            imageSrc = "https://commons.wikimedia.org/wiki/Special:FilePath/Perru_disparue.jpg?width=600"
        )
    )

    val animal: LiveData<Animal?> = _animal

    fun getAnimalRandom(){

        val newAnimal = Animal(
            commonName = "Club-tailed glyptodont",
            location = "South American Pampas",
            imageSrc = "https://commons.wikimedia.org/wiki/Special:FilePath/Doedicurus_reconstruction,_from_Abel,_O._(1912)._Grundz%C3%BCge_der_Palaeobiologie_der_Wirbeltiere.jpg?width=600",
            lastRecord = "4765-4445 BCE"
        )

        _animal.value = newAnimal
    }
}