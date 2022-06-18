package com.chickson.starwars.activities.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chickson.starwars.models.Alert
import com.chickson.starwars.models.Planet
import com.chickson.starwars.models.SWAlert
import com.chickson.starwars.network.services.SWResult
import com.chickson.starwars.repositories.PlanetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    val planets = mutableStateOf(emptyList<Planet>())
    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    val alert = MutableLiveData<SWAlert>()
    private var currentPage = 1
    private var allPlanetsReceived = false
    val currentPlanet = mutableStateOf(Planet())

    fun getPlanets() {
        viewModelScope.launch {
            if (!allPlanetsReceived){
                planetRepository.getPlanets(page = currentPage)
                    .onStart {
                        _isLoading.value = true
                    }
                    .catch { e ->
                        _isLoading.value = false
                    }
                    .collect { response ->
                        _isLoading.value = false
                        when(response){
                            is SWResult.Success -> {
                                planets.value += response.result.results
                                if (response.result.next != null){
                                    currentPage ++
                                } else {
                                    allPlanetsReceived = true
                                }
                            }
                            is SWResult.Failure -> {
                                alert.postValue(SWAlert(type = Alert.ERROR,"We couldn't load Planets."))
                            }

                        }
                    }
            }
            else {
                alert.postValue(SWAlert(type = Alert.INFO,"All Planets have been loaded."))
            }
        }
    }

    fun getPlanet(id: Int){
        currentPlanet.value = planets.value[id]
    }
}