package com.chickson.starwars.views.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chickson.starwars.models.Planet
import com.chickson.starwars.ui.theme.StarWarsTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlanetDetailScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val planet = Planet(name = "Earth", climate = "Mild", orbital_period = "234", gravity = "Standard" )
    @Test
    fun testPlanetDetailViewLoaded(){
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        composeTestRule.setContent {
            StarWarsTheme {
                PlanetDetailScreen(navController = navController, planet = planet)
            }
        }
        composeTestRule.onNodeWithText("${planet.orbital_period}", useUnmergedTree = true).assertIsDisplayed()
    }
}