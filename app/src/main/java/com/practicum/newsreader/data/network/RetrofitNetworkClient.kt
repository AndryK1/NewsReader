package com.practicum.newsreader.data.network

import com.practicum.newsreader.data.dto.NewsDataDto
import com.practicum.newsreader.domain.api.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitNetworkClient(
    private val newsApi : NewsApi
) : NetworkClient {

    override suspend fun doRequest(dto: Any): Response {

        if(dto is NewsSearchRequest){
            return withContext(Dispatchers.IO){
                try {
                    val response = newsApi.search(dto.category, dto.country)

                    if(response.status == "ok" && response.articles.isNotEmpty()){
                        val news = response.articles
                        NewsResponse(
                            status = response.status,
                            totalResults = response.articles.size,
                            articles = news
                        ).apply { resultCode = 200 }
                    }
                    else{
                Response().apply { resultCode = 100 }
            }
                }catch (e: Exception){
                    Response().apply { resultCode = 400 }
                }
            }
        }
        return Response().apply { resultCode = 400 }

    }

}