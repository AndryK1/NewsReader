package com.practicum.newsreader.domain.useCase

import com.practicum.newsreader.domain.api.NewsRepository
import com.practicum.newsreader.domain.api.NewsRepositoryInteractor
import com.practicum.newsreader.domain.data.NewsData
import com.practicum.newsreader.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsRepositoryInteractorImpl(
    val repository: NewsRepository
) : NewsRepositoryInteractor {

    override fun search(
        category: String,
        country: String
    ): Flow<Pair<List<NewsData>?, String?>> {

        return repository.search(category,country).map { result ->

            when(result){
                is Resource.Error -> {
                    Pair(null, result.message)
                }
                is Resource.Success -> {
                    Pair(result.data, null)
                }
            }
        }
    }

}