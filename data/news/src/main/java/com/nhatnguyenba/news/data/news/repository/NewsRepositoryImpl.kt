package com.nhatnguyenba.news.data.news.repository

import com.nhatnguyenba.news.data.news.datasource.remote.NewsRemoteDataSource
import com.nhatnguyenba.news.data.news.mapper.toDomain
import com.nhatnguyenba.news.domain.news.model.Article
import com.nhatnguyenba.news.domain.news.repository.NewsRepository

class NewsRepositoryImpl(
    private val remote: NewsRemoteDataSource
) : NewsRepository {

    override suspend fun getBreakingNews(): List<Article> {
        return remote.getBreakingNews().map { it.toDomain() }
    }

    override suspend fun getRecommendations(): List<Article> {
        return remote.getRecommendations().map { it.toDomain() }
    }
}