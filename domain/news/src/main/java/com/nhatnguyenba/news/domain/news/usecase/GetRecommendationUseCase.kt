package com.nhatnguyenba.news.domain.news.usecase

import com.nhatnguyenba.news.domain.news.repository.NewsRepository

class GetRecommendationUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke() = repository.getRecommendations()
}