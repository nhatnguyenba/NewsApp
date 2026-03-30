package com.nhatnguyenba.news.home.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nhatnguyenba.news.domain.news.model.Article
import com.nhatnguyenba.news.home.presentation.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state = viewModel.state

    LazyColumn {
        item {
            Text("Breaking News", style = MaterialTheme.typography.titleLarge)
        }

        item {
            BreakingNewsCarousel(state.breakingNews)
        }

        item {
            Text("Recommendation", style = MaterialTheme.typography.titleLarge)
        }

        items(state.recommendations.size) { index ->
            RecommendationItem(state.recommendations[index])
        }
    }
}

@Composable
fun BreakingNewsCarousel(articles: List<Article>) {
    LazyRow {
        items(articles.size) { index ->
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = articles[index].imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )

                Text(
                    text = articles[index].title,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.BottomStart)
                )
            }
        }
    }
}

@Composable
fun RecommendationItem(article: Article) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(article.title, maxLines = 2)
            Text(article.author, style = MaterialTheme.typography.bodySmall)
        }
    }
}