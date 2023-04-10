package com.example.podcast.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.podcast.di.Navigator
import com.example.podcast.ui.navigation.AuthRoutes
import com.example.podcast.ui.screens.SignUpScreen
import com.example.podcast.ui.screens.SplashScreen


@Composable
fun Navigation(navController: NavHostController, navigator: Navigator) {
    LaunchedEffect("navigator") {
        navigator.sharedFlow.collect {
            navController.navigate(it.route)
        }
    }

    NavHost(navController = navController, startDestination = AuthRoutes.Splash.route) {
        composable(AuthRoutes.Splash.route) {
            SplashScreen()
        }

        composable(AuthRoutes.SignUp.route) {
            SignUpScreen()
        }

        composable(AuthRoutes.SignIn.route) {
            // todo : add the sign in screen
        }

    }
}