package com.practicum.newsreader.utils

import android.app.Application
import com.practicum.newsreader.di.dataModule
import com.practicum.newsreader.di.interactorModule
import com.practicum.newsreader.di.networkClientModule
import com.practicum.newsreader.di.repositoryModule
import com.practicum.newsreader.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(interactorModule,viewModelModule, repositoryModule, dataModule,
                networkClientModule
            )
        }
    }
}