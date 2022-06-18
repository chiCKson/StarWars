package com.chickson.starwars.activities.dashboard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chickson.starwars.navigation.Navigation
import com.chickson.starwars.models.Alert
import com.chickson.starwars.ui.theme.StarWarsTheme
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty


@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {

    private val viewModel by viewModels<DashboardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.alert.observe(this){ alert ->
            when(alert.type){
                Alert.INFO -> {
                    Toasty.info(this@DashboardActivity,alert.messge,Toast.LENGTH_LONG).show()
                }
                Alert.ERROR -> {
                    Toasty.error(this@DashboardActivity,alert.messge,Toast.LENGTH_LONG).show()
                }
                Alert.SUCCESS -> {
                    Toasty.success(this@DashboardActivity,alert.messge,Toast.LENGTH_LONG).show()
                }
            }
        }
        setContent {
            StarWarsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StarWarsTheme {
        Greeting("Android")
    }
}