package com.chickson.starwars.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.chickson.starwars.activities.dashboard.DashboardViewModel

@Composable
fun Loader(){
    Box(
        modifier = Modifier  .fillMaxSize()
            .background(MaterialTheme.colors.primary.copy(alpha = 0.3f)),
    )
    CircularProgressIndicator()
}