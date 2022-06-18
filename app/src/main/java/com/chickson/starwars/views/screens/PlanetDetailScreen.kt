package com.chickson.starwars.views.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.chickson.starwars.activities.dashboard.DashboardViewModel
import com.chickson.starwars.models.Planet
import com.chickson.starwars.views.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlanetDetailScreen(
    navController: NavHostController,
    planet: Planet
) {

    val configuration = LocalConfiguration.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    navController = navController,
                    title = planet.name.toString()
                )
            },
            content = {
                Column() {
                    AsyncImage(
                        model = "https://picsum.photos/seed/${planet.name}/200/300",
                        contentDescription = "Planet",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(configuration.screenHeightDp.dp / 3),
                    )
                    Row(Modifier.padding(20.dp)) {
                        Text(
                            text = "Planet Name: ",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = planet.name.toString()
                        )
                    }
                    Row(Modifier.padding(20.dp))  {
                        Text(
                            text = "Orbital Period: ",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = planet.orbital_period.toString()
                        )
                    }
                    Row(Modifier.padding(20.dp))  {
                        Text(
                            text = "Gravity: ",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = planet.gravity.toString()
                        )
                    }
                }
            }
        )
    }
}