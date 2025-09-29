package com.practicum.newsreader.data.network

import com.practicum.newsreader.data.dto.NewsDataDto

data class NewsResponse(
    val totalResults: Int,
    val news: List<NewsDataDto>
) : Response()