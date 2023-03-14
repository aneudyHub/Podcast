package com.example.podcast.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity : BaseActivity() {

    @Composable
    override fun BaseContentContainer() {
        val navController = rememberNavController()
        val currentRoute by navViewModel.navigation.collectAsState()
        LaunchedEffect(currentRoute) {
            if (currentRoute.route != "")
                navController.navigate(currentRoute.route)
        }
        AuthNavigation(navController = navController)
    }

}