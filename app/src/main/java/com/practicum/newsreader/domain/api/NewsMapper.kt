package com.practicum.newsreader.domain.api

import com.practicum.newsreader.data.dto.NewsDataDto
import com.practicum.newsreader.domain.data.NewsData

interface NewsMapper {

    fun map(newsData: NewsData) : NewsDataDto
    fun map(newsDataDto: NewsDataDto) : NewsData
}