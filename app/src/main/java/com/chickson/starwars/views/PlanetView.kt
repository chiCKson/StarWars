package com.chickson.starwars.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chickson.starwars.models.Planet
import com.chickson.starwars.navigation.Screen

@Composable
fun PlanetView(navController: NavController, planet: Planet){
    val configuration = LocalConfiguration.current
    Card( modifier = Modifier
        .width(configuration.screenWidthDp.dp)
        .clickable {
            navController.navigate(Screen.PlanetScreen.withArgs("1"))
        },
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        Column (modifier = Modifier.padding(10.dp)){
            Text("Planet Name ${planet.name}")
            Text("Climate ${planet.climate}")
        }
    }
}