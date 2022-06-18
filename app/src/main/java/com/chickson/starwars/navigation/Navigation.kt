package com.chickson.starwars

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chickson.starwars.activities.dashboard.DashboardViewModel
import com.chickson.starwars.navigation.Screen
import com.chickson.starwars.views.TopBar
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
                type = NavType.StringType
                defaultValue = "1"
                nullable = false
            }
        )) {
            PlanetDetailView(navController = navController,viewModel = viewModel, planetId = it.arguments?.getString("id")!!.toInt() )
            //viewModel.getPlanets()
        }
    }
}



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlanetDetailView(viewModel: DashboardViewModel, planetId: Int, navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(
            topBar = {
                TopBar(navController = navController)
            },
            content = {
                Text("Planet Details")
            }
        )
    }
}
