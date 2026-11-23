package com.example.sesion3_03_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.sesion3_03_base.ui.theme.Sesion3_03_BaseTheme
import com.example.sesion3_03_base.viewmodel.AnimalViewModel
import com.example.sesion3_03_base.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<AnimalViewModel>()
        setContent {
            Sesion3_03_BaseTheme {
                HomeView(viewModel)
            }
        }
    }
}

