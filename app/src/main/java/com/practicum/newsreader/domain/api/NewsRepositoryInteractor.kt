package com.practicum.newsreader.domain.api

import com.practicum.newsreader.domain.data.NewsData
import kotlinx.coroutines.flow.Flow

interface NewsRepositoryInteractor {

    fun search(category: String, country: String) : Flow<Pair<List<NewsData>?, String?>>
}