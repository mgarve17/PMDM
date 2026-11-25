package com.example.ut2_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ut2_10.ui.theme.* // Importa el tema de tu proyecto automáticamente
import com.example.ut2_10.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Pon la primera letra en mayúscula (Ut2_10Theme o UT2_10Theme)
            UT2_10Theme {
                HomeView()
            }
        }
    }
}