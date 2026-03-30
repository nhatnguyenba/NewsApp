package com.nhatnguyenba.news.network.api

import com.nhatnguyenba.news.network.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("everything")
    suspend fun getRecommendations(
        @Query("q") query: String = "technology",
        @Query("apiKey") apiKey: String
    ): NewsResponse
}