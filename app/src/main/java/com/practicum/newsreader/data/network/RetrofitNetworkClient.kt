package com.practicum.newsreader.data.network

import com.practicum.newsreader.domain.api.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitNetworkClient(
    private val sauravServise : NewsApi
) : NetworkClient {

    override suspend fun doRequest(dto: Any): Response {

        if(dto is NewsSearchRequest){
            return withContext(Dispatchers.IO){
                try {
                    val response = sauravServise.search(dto.category, dto.country)

                    if(response.news.isEmpty()){
                        Response().apply { resultCode == 100 }
                    }
                    else{
                        NewsResponse(
                            totalResults = response.news.size,
                            news = response.news
                        ).apply { resultCode == 200 }
                    }
                }catch (e: Exception){
                    Response().apply { resultCode == 400 }
                }
            }
        }
        return Response().apply { resultCode == 400 }

    }

}