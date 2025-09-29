package com.practicum.newsreader.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {

    @GET("top-headlines/category/{category}/{country}/json")
    suspend fun search(
        @Path("category") category: String,
        @Path("country") country : String
    ) : NewsResponse
}