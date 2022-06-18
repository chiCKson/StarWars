package com.chickson.starwars.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.chickson.starwars.models.Planet
import com.chickson.starwars.navigation.Screen
import com.chickson.starwars.utils.TestTags

@Composable
fun PlanetView(navController: NavController, planet: Planet, index: Int){
    val configuration = LocalConfiguration.current
    Card( modifier = Modifier
        .width(configuration.screenWidthDp.dp)
        .clickable {
            navController.navigate(Screen.PlanetScreen.withArgs(index))
        }.testTag(TestTags.planetViewCard),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://picsum.photos/seed/${planet.name}/200/300",
                contentDescription = "News article",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp).clip(CircleShape),
            )
            Column (
                modifier = Modifier.padding(start = 10.dp),
                verticalArrangement = Arrangement.Center
                    ){
                Text("Planet Name: ${planet.name}")
                Text("Climate: ${planet.climate}")
            }
        }
    }
}