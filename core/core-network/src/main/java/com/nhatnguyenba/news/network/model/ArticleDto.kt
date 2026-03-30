package com.nhatnguyenba.news.network.model

data class ArticleDto(
    val title: String,
    val urlToImage: String?,
    val author: String?,
    val publishedAt: String?
)