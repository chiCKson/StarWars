package com.chickson.starwars.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chickson.starwars.R
import com.chickson.starwars.navigation.Screen

@Composable
fun TopBar(navController: NavController){
    TopAppBar(
        title = {
            Text(
                text = "Star Wars Planets",
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