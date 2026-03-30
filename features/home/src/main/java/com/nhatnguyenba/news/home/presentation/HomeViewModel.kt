package com.nhatnguyenba.news.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhatnguyenba.news.domain.news.usecase.GetBreakingNewsUseCase
import com.nhatnguyenba.news.domain.news.usecase.GetRecommendationUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getBreakingNews: GetBreakingNewsUseCase,
    private val getRecommendation: GetRecommendationUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            val breaking = async { getBreakingNews() }
            val recommend = async { getRecommendation() }

            state = state.copy(
                breakingNews = breaking.await(),
                recommendations = recommend.await(),
                isLoading = false
            )
        }
    }
}