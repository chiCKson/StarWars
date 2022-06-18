package com.chickson.starwars.system

import com.chickson.starwars.repositories.PlanetRepositoryImpl

import com.chickson.starwars.repositories.interfaces.PlanetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindingFunctionPlanets(impl: PlanetRepositoryImpl) : PlanetRepository

}