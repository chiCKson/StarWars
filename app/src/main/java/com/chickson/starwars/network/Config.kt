package com.chickson.starwars.network

import android.util.Log
import com.chickson.starwars.BuildConfig
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

class Config @Inject constructor() {
    val client = HttpClient(Android) {
        install(DefaultRequest) {
            headers.append("Content-Type", "application/json")
            host = BuildConfig.API_HOST
            //parameter("apiKey",BuildConfig.NEWS_API_KEY)
            url {
                protocol = URLProtocol.HTTPS
            }
        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }
            }
            level = LogLevel.ALL
        }
        engine {
            connectTimeout = 100_000
            socketTimeout = 100_000
        }
    }
}