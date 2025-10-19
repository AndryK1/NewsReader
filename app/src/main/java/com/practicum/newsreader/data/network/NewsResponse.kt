package com.practicum.newsreader.data.network

import com.practicum.newsreader.data.dto.NewsDataDto

data class NewsResponse(
    val status : String,
    val totalResults: Int,
    val articles: List<NewsDataDto>
) : Response()