package com.nhatnguyenba.news.domain.news.repository

import com.nhatnguyenba.news.domain.news.model.Article

interface NewsRepository {
    suspend fun getBreakingNews(): List<Article>
    suspend fun getRecommendations(): List<Article>
}