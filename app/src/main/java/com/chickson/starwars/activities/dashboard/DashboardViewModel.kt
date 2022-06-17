package com.chickson.starwars.activities.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chickson.starwars.network.services.SWResult
import com.chickson.starwars.repositories.PlanetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject
constructor(
    private val planetRepository: PlanetRepository
): ViewModel() {
    fun getPlanets() {
        viewModelScope.launch {
            planetRepository.getPlanets(page = 1)
                .onStart {
                    //isLoading.value = true
                }
                .catch { e ->
                    //isLoading.value = false
                }
                .collect { response ->
                   when(response){
                       is SWResult.Success -> {
                           println(response.result.results)
                       }
                       is SWResult.Failure -> {
                           println(response)
                       }

                   }
                }
        }
    }
}