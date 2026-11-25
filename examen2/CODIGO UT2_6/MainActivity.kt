package com.example.ut2_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ut2_6.ui.theme.UT2_6Theme
import com.example.ut2_6.viewmodels.ContadorViewModel
import com.example.ut2_6.viewmodels.GrupoAleatViewModel
import com.example.ut2_6.views.ContadorView
import com.example.ut2_6.views.GrupoAleatView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT2_6Theme {
                //ContadorView(ContadorViewModel())
                GrupoAleatView(GrupoAleatViewModel())
            }
        }
    }
}