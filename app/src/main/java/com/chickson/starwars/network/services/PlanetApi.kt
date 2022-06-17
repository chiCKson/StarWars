package com.chickson.starwars.network.services

import com.chickson.starwars.models.Planet
import com.chickson.starwars.models.SWResponse
import com.chickson.starwars.network.Config
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import javax.inject.Inject


class PlanetApi @Inject constructor(private val config: Config)  {
    suspend fun getPlanets(page: Int): SWResult<SWResponse<List<Planet>>> {
        val response: SWResponse<List<Planet>> =  config.client.get(path = "api/planets/"){
            parameter("page", page)
        }
        return if (response.detail == null) {
            SWResult.Success(response)
        } else {
            SWResult.Failure(response.detail!!)
        }
    }

    suspend fun getPlanet(id: Int): SWResult<SWResponse<Planet>> {
        val response: SWResponse<Planet> =  config.client.get(path = "api/planets/$id")
        return if (response.detail == null) {
            SWResult.Success(response)
        } else {
            SWResult.Failure(response.detail!!)
        }
    }
}

sealed class SWResult<out T> {
    data class Success<out T>(val result: T): SWResult<T>()
    data class Failure(val message: String) : SWResult<Nothing>()
}