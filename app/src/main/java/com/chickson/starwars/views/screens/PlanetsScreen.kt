package com.chickson.starwars.views.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chickson.starwars.activities.dashboard.DashboardViewModel
import com.chickson.starwars.utils.*
import com.chickson.starwars.views.*



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlanetsScreen(navController: NavController, viewModel: DashboardViewModel) {
    val listState = rememberLazyListState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(
            topBar = {
                TopBar(navController = navController)
            },
            content = {
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    itemsIndexed(viewModel.planets.value) { index, planet ->
                        PlanetView(navController = navController, planet = planet, index = index)
                    }

                }
                if (listState.isScrolledToTheEnd() && listState.isScrollInProgress) {
                    viewModel.getPlanets()
                }
            }
        )
        if (viewModel.isLoading.collectAsState().value) {
            Loader()
        }
    }
}



