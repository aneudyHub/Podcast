package com.example.podcast.ui

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.podcast.di.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthenticationActivity : BaseActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Composable
    override fun BaseContentContainer() {
        val navController = rememberNavController()
        Navigation(navController, navigator)
    }

}