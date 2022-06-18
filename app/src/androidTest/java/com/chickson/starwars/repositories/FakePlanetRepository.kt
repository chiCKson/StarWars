package com.chickson.starwars.repositories


import com.chickson.starwars.models.Planet
import com.chickson.starwars.models.SWResponse
import com.chickson.starwars.network.services.SWResult
import com.chickson.starwars.repositories.interfaces.PlanetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FakePlanetRepository @Inject
constructor(): PlanetRepository {

    private val planets = listOf<Planet>(
        Planet(name = "Earth", climate = "Tropical"),
        Planet(name = "Mars", climate = "Hot")
    )
    override fun getPlanets(page: Int): Flow<SWResult<SWResponse<List<Planet>>>> = flow {
        emit(SWResult.Success(SWResponse(results = planets,count = 2, next = "", previous = "")))
    }.flowOn(Dispatchers.IO)

    override fun getPlanet(id: Int): Flow<SWResult<SWResponse<Planet>>> = flow{
        emit(SWResult.Success(SWResponse(results = planets.first(),count = 2, next = "", previous = "")))
    }.flowOn(Dispatchers.IO)

}