package com.practicum.newsreader.domain.api

import com.practicum.newsreader.data.network.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any) : Response
}