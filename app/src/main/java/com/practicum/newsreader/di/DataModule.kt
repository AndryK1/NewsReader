package com.practicum.newsreader.di

import com.practicum.newsreader.domain.api.NewsMapper
import com.practicum.newsreader.domain.impl.NewsMapperImpl
import org.koin.dsl.module

val dataModule = module {
    factory<NewsMapper> {
        NewsMapperImpl()
    }
}