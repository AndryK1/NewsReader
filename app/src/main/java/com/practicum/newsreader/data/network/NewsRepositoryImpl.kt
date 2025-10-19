package com.practicum.newsreader.data.network

import android.util.Log
import com.practicum.newsreader.domain.api.NetworkClient
import com.practicum.newsreader.domain.api.NewsMapper
import com.practicum.newsreader.domain.api.NewsRepository
import com.practicum.newsreader.domain.data.NewsData
import com.practicum.newsreader.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(
    val networkClient: NetworkClient,
    val mapper: NewsMapper
) : NewsRepository {

    override fun search(category: String, country: String) : Flow<Resource<List<NewsData>>> = flow{

        val response = networkClient.doRequest(NewsSearchRequest(category,country))

        when(response.resultCode){
            200 -> {
                if (response is NewsResponse){
                    val data = response.articles.map { mapper.map(it) }

                    emit(Resource.Success(data))

                }
                else{
                    emit(Resource.Error("looks like there is a problem with internet", emptyList()))

                }
            }
            100 -> {
                emit(Resource.Error("looks like there is a problem with internet", emptyList()))

            }
            400 -> {
                emit(Resource.Error("There is an error occurred while loading data", emptyList()))

            }
        }
    }

}