package com.practicum.newsreader.domain.data

import java.time.Instant

data class NewsData (
    val uuid : String,
    val title: String,
    val description: String?,
    val urlToFullNews: String?,
    val urlToPoster: String?,
    val publishedAt: Instant,
    val publisher: String
)