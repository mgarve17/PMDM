package com.example.ut2_3.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ut2_3.components.ActionButton
import com.example.ut2_3.components.MainButton
import com.example.ut2_3.components.SpaceV
import com.example.ut2_3.components.TitleBar
import com.example.ut2_3.components.TitleView

@Composable
fun ContentHomeView(navController: NavController) {
    val n = 123
    val user = "Juan"
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        SpaceV()
        MainButton(
            name = "To Detail",
            onClick = { navController.navigate("Detail/${n}/${user}") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(texto = "TOP BAR") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)
    }
}