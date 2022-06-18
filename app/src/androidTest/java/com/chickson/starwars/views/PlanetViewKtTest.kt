package com.chickson.starwars.views

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chickson.starwars.models.Planet
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PlanetViewKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val planet = Planet(name = "Earth", climate = "Mild")

    @Test
    fun testPlanetViewLoaded(){
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        composeTestRule.setContent {
            PlanetView(navController = navController, planet = planet, index = 1)
        }
        composeTestRule.onNodeWithText("Planet Name: ${planet.name}").assertIsDisplayed()
    }

}