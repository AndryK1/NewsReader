package com.practicum.newsreader.di

import com.practicum.newsreader.data.network.NewsRepositoryImpl
import com.practicum.newsreader.domain.api.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<NewsRepository> {
        NewsRepositoryImpl(get(), get())
    }


}