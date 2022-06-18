package com.chickson.starwars.models


data class Planet(
    var climate: String? = null,
    var created: String? = null,
    var diameter: String? = null,
    var edited: String? = null,
    var films: List<String>? = null,
    var gravity: String? = null,
    var name: String? = null,
    var orbital_period: String? = null,
    var population: String? = null,
    var residents: List<String>? = null,
    var rotation_period: String? = null,
    var surface_water: String? = null,
    var terrain: String? = null,
    var url: String? = null
)