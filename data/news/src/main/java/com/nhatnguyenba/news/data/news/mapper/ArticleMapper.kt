package com.nhatnguyenba.news.data.news.mapper

import com.nhatnguyenba.news.domain.news.model.Article
import com.nhatnguyenba.news.network.model.ArticleDto

fun ArticleDto.toDomain(): Article {
    return Article(
        id = title,
        title = title,
        imageUrl = urlToImage.orEmpty(),
        author = author.orEmpty(),
        publishedAt = publishedAt.orEmpty(),
        category = "General"
    )
}