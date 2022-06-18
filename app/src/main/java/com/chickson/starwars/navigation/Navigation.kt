package com.chickson.starwars.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chickson.starwars.activities.dashboard.DashboardViewModel
import com.chickson.starwars.views.screens.PlanetDetailScreen
import com.chickson.starwars.views.screens.PlanetsScreen

@Composable
fun Navigation(viewModel: DashboardViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.DashboardScreen.route){

        composable(Screen.DashboardScreen.route) {
            viewModel.getPlanets()
            PlanetsScreen(navController = navController,viewModel = viewModel)
        }

        composable(route = Screen.PlanetScreen.route + "/{id}", arguments = listOf(
            navArgument(name = "id"){
                type = NavType.IntType
                defaultValue = 1
                nullable = false
            }
        )) {
            viewModel.getPlanet(id = it.arguments?.getInt("id")!!)
            PlanetDetailScreen(navController = navController,planet = viewModel.currentPlanet.value)
        }

    }
}




