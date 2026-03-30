package com.nhatnguyenba.newsapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nhatnguyenba.news.home.ui.screen.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(padding)
    ) {

        composable("home") {
            HomeScreen()
        }

        composable("search") {
//            SearchScreen()
        }

        composable("bookmark") {
//            BookmarkScreen()
        }
    }
}