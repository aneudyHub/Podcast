package com.example.podcast.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.podcast.ui.navigation.AuthRoutes
import com.example.podcast.ui.screens.SplashScreen


@Composable
fun AuthNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AuthRoutes.Splash.route) {
        composable(AuthRoutes.Splash.route) {
            SplashScreen()
        }

        composable(AuthRoutes.SignUp.route) {
            // todo : add the new account screen
        }

        composable(AuthRoutes.SignIn.route) {
            // todo : add the sign in screen
        }

    }
}