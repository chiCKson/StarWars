package com.chickson.starwars.views

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.chickson.starwars.navigation.Screen

@Composable
fun TopBar(navController: NavController, title: String = "Star Wars Planets"){
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h1
            )
        },

        navigationIcon = {

            if (navController.currentDestination!!.route != Screen.DashboardScreen.route){
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            }

        },
        backgroundColor = MaterialTheme.colors.primary)
}

