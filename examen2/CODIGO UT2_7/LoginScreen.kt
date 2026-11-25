package com.example.ut_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.ut_7.viewmodels.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Login(loginViewModel = loginViewModel)
    }
}

@Composable
fun Login(loginViewModel: LoginViewModel) {
    // 4. Observación de estados expuestos por el ViewModel
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by loginViewModel.loginEnable.observeAsState(initial = false)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 4.1. Campo de Email
        EmailField(
            email = email,
            onTextFieldChanged = { newEmail ->
                loginViewModel.onLoginChanged(emailInput = newEmail, passwordInput = password)
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 4.2. Campo de Password
        PasswordField(
            password = password,
            onTextFieldChanged = { newPassword ->
                loginViewModel.onLoginChanged(emailInput = email, passwordInput = newPassword)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 4.3. Botón de Login
        LoginButton(
            loginEnabled = loginEnable,
            onLoginSelected = { loginViewModel.onLoginSelected() }
        )
    }
}

@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Correo electrónico") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun LoginButton(loginEnabled: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = onLoginSelected,
        modifier = Modifier.fillMaxWidth(),
        enabled = loginEnabled
    ) {
        Text("Iniciar sesión")
    }
}