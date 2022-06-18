package com.chickson.starwars.system

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakePlanetsImplementor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PlanetsImplementor