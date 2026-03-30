package com.nhatnguyenba.news.data.news.datasource.remote

import com.nhatnguyenba.news.network.api.NewsApi
import com.nhatnguyenba.news.network.model.ArticleDto

class NewsRemoteDataSource(
    private val api: NewsApi
) {
    val API_KEY = ""
    suspend fun getBreakingNews(): List<ArticleDto> {
        return api.getBreakingNews(
            country = "us",
            apiKey = API_KEY
        ).articles
    }

    suspend fun getRecommendations(): List<ArticleDto> {
        return api.getRecommendations(
            query = "technology",
            apiKey = API_KEY
        ).articles
    }
}