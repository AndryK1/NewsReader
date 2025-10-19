package com.practicum.newsreader.domain.impl

import com.practicum.newsreader.data.dto.NewsDataDto
import com.practicum.newsreader.domain.api.NewsMapper
import com.practicum.newsreader.domain.data.NewsData
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class NewsMapperImpl : NewsMapper {

    override fun map(newsData: NewsData) : NewsDataDto {
        return NewsDataDto(
            id = newsData.id,
            name = newsData.name,
            author = newsData.author,
            title = newsData.title,
            description = newsData.description,
            url = newsData.url,
            urlToImage = newsData.urlToImage,
            publishedAt = newsData.publishedAt,
            content = newsData.content
        )
    }

    override fun map(newsDataDto: NewsDataDto) : NewsData {
        return NewsData(
            id = newsDataDto.id,
            name = newsDataDto.name ?: "Unknown Source",
            author = newsDataDto.author,
            title = newsDataDto.title,
            description = newsDataDto.description,
            url = newsDataDto.url,
            urlToImage = newsDataDto.urlToImage,
            publishedAt = formatTime(newsDataDto.publishedAt),
            content = newsDataDto.content
        )
    }

    private fun formatTime(date : String) : String{
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'в' HH:mm")
            .withZone(ZoneId.systemDefault())
        try{
            val instant = Instant.parse(date)
            return formatter.format(instant)
        } catch (e : Exception){
            val instant = Instant.now()
            return formatter.format(instant)
        }
    }
}