package com.practicum.newsreader.domain.data

import java.time.Instant

data class NewsData (

    val id: String?,
    val name: String?,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)