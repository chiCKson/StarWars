package com.chickson.starwars.models

data class SWAlert (val type: Alert, val messge: String)

enum class Alert {
    INFO,
    ERROR,
    SUCCESS
}