package com.practicum.newsreader.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun search(
        @Query("category") category: String,
        @Query("country") country : String,
        @Query("apiKey") apiKey : String = "f758e44628df4a1eb463595333135d76"
    ) : NewsResponse
}