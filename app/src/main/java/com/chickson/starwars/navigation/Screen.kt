package com.chickson.starwars.navigation

sealed class Screen(val route: String) {
    object DashboardScreen: Screen(route = "dashboard_screen")
    object PlanetScreen: Screen(route = "planet_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                    append("/$arg")
            }
        }
    }
}
