package com.example.podcast.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.podcast.di.Navigator
import com.example.podcast.ui.navigation.AuthRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val navigator: Navigator
) : ViewModel() {

    fun createNewAccountPressed() {
        navigator.navigateTo(AuthRoutes.SignUp)
    }

    fun signInPressed() {
        navigator.navigateTo(AuthRoutes.SignIn)
    }
}