package com.practicum.newsreader.di

import com.practicum.newsreader.data.network.NewsApi
import com.practicum.newsreader.data.network.RetrofitNetworkClient
import com.practicum.newsreader.domain.api.NetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkClientModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(get())
    }

}