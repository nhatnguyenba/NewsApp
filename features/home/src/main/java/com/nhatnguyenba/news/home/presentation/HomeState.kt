package com.nhatnguyenba.news.home.presentation

import com.nhatnguyenba.news.domain.news.model.Article

data class HomeState(
    val breakingNews: List<Article> = emptyList(),
    val recommendations: List<Article> = emptyList(),
    val isLoading: Boolean = false
)