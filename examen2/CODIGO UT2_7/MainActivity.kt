package com.example.ut_7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.ut_7.LoginScreen
import com.example.ut_7.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {

    // Instancia del ViewModel retenida ante cambios de configuración
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    LoginScreen(loginViewModel = loginViewModel)
                }
            }
        }
    }
}