package com.example.ut2_3.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ut2_3.components.MainButton
import com.example.ut2_3.components.MainIconButton
import com.example.ut2_3.components.SpaceV
import com.example.ut2_3.components.TitleBar
import com.example.ut2_3.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, num: Int, usuario: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(texto = "TOP BAR DETAIL") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetailView(navController, num, usuario)
    }
}

@Composable
fun ContentDetailView(navController: NavController, num: Int, usuario: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Detail View")
        SpaceV()
        TitleView(name = num.toString())
        SpaceV()
        TitleView(name = usuario)
        SpaceV(20.dp)
        MainButton(
            name = "Return home",
            onClick = {
                navController.popBackStack()
            }
        )
    }
}