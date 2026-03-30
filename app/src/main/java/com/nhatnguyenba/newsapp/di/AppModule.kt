package com.nhatnguyenba.newsapp.di

import com.nhatnguyenba.news.data.news.datasource.remote.NewsRemoteDataSource
import com.nhatnguyenba.news.data.news.repository.NewsRepositoryImpl
import com.nhatnguyenba.news.domain.news.repository.NewsRepository
import com.nhatnguyenba.news.domain.news.usecase.GetBreakingNewsUseCase
import com.nhatnguyenba.news.domain.news.usecase.GetRecommendationUseCase
import com.nhatnguyenba.news.home.presentation.HomeViewModel
import com.nhatnguyenba.news.network.api.NewsApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }
}

val repositoryModule = module {

    single<NewsRemoteDataSource> {
        NewsRemoteDataSource(get())
    }

    single<NewsRepository> {
        NewsRepositoryImpl(get())
    }
}

val useCaseModule = module {

    factory {
        GetBreakingNewsUseCase(get())
    }

    factory {
        GetRecommendationUseCase(get())
    }
}

val viewModelModule = module {

    viewModel {
        HomeViewModel(get(), get())
    }
}

