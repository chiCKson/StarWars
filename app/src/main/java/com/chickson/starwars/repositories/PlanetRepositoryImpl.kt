package com.chickson.starwars.repositories

import com.chickson.starwars.models.Planet
import com.chickson.starwars.models.SWResponse
import com.chickson.starwars.network.services.PlanetApi
import com.chickson.starwars.network.services.SWResult
import com.chickson.starwars.repositories.interfaces.PlanetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlanetRepositoryImpl
@Inject
constructor(private val planetSource: PlanetApi): PlanetRepository {

    override fun getPlanets(page: Int) : Flow<SWResult<SWResponse<List<Planet>>>> = flow {
        emit(planetSource.getPlanets(page = page))
    }.flowOn(Dispatchers.IO)

    override fun getPlanet(id: Int) : Flow<SWResult<SWResponse<Planet>>> = flow {
        emit(planetSource.getPlanet(id = id))
    }.flowOn(Dispatchers.IO)
}

