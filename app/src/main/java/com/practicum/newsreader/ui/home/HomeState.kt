package com.practicum.newsreader.ui.home

import com.practicum.newsreader.domain.data.NewsData

sealed interface HomeState {

    object Empty : HomeState
    data class ShowContent(val data: List<NewsData>) : HomeState
    data class ShowError(val message: String) : HomeState
}