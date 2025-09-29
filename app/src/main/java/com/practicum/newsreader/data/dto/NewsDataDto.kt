package com.practicum.newsreader.data.dto

data class NewsDataDto(
    val uuid : String,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String,
    val source: String
)