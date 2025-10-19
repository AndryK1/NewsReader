package com.practicum.newsreader.di

import com.practicum.newsreader.domain.api.NewsRepositoryInteractor
import com.practicum.newsreader.domain.useCase.NewsRepositoryInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    factory<NewsRepositoryInteractor> {
        NewsRepositoryInteractorImpl(get())
    }
}