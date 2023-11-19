package com.example.laughmania.data.network

import android.util.Log
import com.example.laughmania.data.models.RandomData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClient {
    private val apiClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true}
            )
        }
    }

    //Function for the Random Jokes
    suspend fun getRandomJokes() : RandomData {

        val url = "https://api.chucknorris.io/jokes/random"
        val response = apiClient.get(url).body() as RandomData
        Log.d("TAG","$response")
        return response
    }



}

