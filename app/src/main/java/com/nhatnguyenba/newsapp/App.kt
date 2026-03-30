package com.nhatnguyenba.newsapp

import android.app.Application
import com.nhatnguyenba.newsapp.di.networkModule
import com.nhatnguyenba.newsapp.di.repositoryModule
import com.nhatnguyenba.newsapp.di.useCaseModule
import com.nhatnguyenba.newsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        val appModule = listOf(
            networkModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}

