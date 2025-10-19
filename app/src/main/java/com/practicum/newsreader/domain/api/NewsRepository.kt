package com.practicum.newsreader.domain.api

import com.practicum.newsreader.domain.data.NewsData
import com.practicum.newsreader.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun search(category: String, country: String) : Flow<Resource<List<NewsData>>>
}