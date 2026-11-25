package com.example.ut_7.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    // --- 3. LiveData para Email ---
    // Encapsulamiento: mutable privado y exposición inmutable
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    // --- LiveData para Password ---
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    // --- 4.3. LiveData para habilitar el Botón de Login ---
    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    // Función que actualiza los estados y valida
    fun onLoginChanged(emailInput: String, passwordInput: String) {
        _email.value = emailInput
        _password.value = passwordInput
        _loginEnable.value = isValidEmail(emailInput) && isValidPassword(passwordInput)
    }

    // Validaciones de negocio
    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean =
        password.length >= 6

    // Acción al pulsar el botón de login
    fun onLoginSelected() {
        // Lógica de autenticación o llamada al backend
        println("Iniciando sesión con email: ${_email.value}")
    }
}