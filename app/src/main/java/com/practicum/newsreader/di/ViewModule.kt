package com.practicum.newsreader.di

import androidx.lifecycle.viewmodel.viewModelFactory
import com.practicum.newsreader.ui.home.viewModels.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(get())
    }
}