package com.example.podcast.ui.viewmodels

import com.example.podcast.ui.navigation.AuthRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    fun createNewAccountPressed() {
        navigate(AuthRoutes.SignUp)
    }

    fun signInPressed() {
        navigate(AuthRoutes.SignIn)
    }
}