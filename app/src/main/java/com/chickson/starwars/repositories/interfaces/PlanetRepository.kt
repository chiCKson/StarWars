package com.chickson.starwars.repositories.interfaces

import com.chickson.starwars.models.Planet
import com.chickson.starwars.models.SWResponse
import com.chickson.starwars.network.services.SWResult
import kotlinx.coroutines.flow.Flow

interface PlanetRepository {
    fun getPlanets(page: Int) : Flow<SWResult<SWResponse<List<Planet>>>>
    fun getPlanet(id: Int) : Flow<SWResult<SWResponse<Planet>>>
}