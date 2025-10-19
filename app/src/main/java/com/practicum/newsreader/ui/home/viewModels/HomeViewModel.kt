package com.practicum.newsreader.ui.home.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.newsreader.domain.api.NewsRepositoryInteractor
import com.practicum.newsreader.ui.home.HomeState
import kotlinx.coroutines.launch

class HomeViewModel(
    val interactor: NewsRepositoryInteractor
) : ViewModel() {

    private var state = MutableLiveData<HomeState>(HomeState.Empty)
    fun observeState() : LiveData<HomeState> = state

    fun updateNews(category: String, country: String) {
        Log.d("HomeViewModel", "updateNews called with category: $category, country: $country")

        viewModelScope.launch {
            Log.d("HomeViewModel", "Coroutine started")

            try {
                interactor.search(category, country).collect { news ->
                    Log.d("HomeViewModel", "Received news: first=${news.first?.size}, second=${news.second}")

                    if(news.first?.isEmpty() == true && news.second?.isEmpty() == true) {
                        Log.d("HomeViewModel", "State: Empty")
                        state.postValue(HomeState.Empty)
                    } else if(news.first?.isNotEmpty() == true) {
                        Log.d("HomeViewModel", "State: ShowContent with ${news.first!!.size} items")
                        state.postValue(HomeState.ShowContent(news.first!!))
                    } else {
                        Log.d("HomeViewModel", "State: ShowError")
                        state.postValue(HomeState.ShowError(""))
                    }
                }
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error in updateNews", e)
                state.postValue(HomeState.ShowError(e.message ?: "Unknown error"))
            }
        }
    }
}