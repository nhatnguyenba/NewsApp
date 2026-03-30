package com.nhatnguyenba.news.domain.news.model

data class Article(
    val id: String,
    val title: String,
    val imageUrl: String,
    val author: String,
    val publishedAt: String,
    val category: String
)