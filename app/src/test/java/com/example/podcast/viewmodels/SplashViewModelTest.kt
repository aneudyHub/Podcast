package com.example.podcast.viewmodels

import app.cash.turbine.test
import com.example.podcast.di.Navigator
import com.example.podcast.ui.navigation.AuthRoutes
import com.example.podcast.ui.viewmodels.SplashViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SplashViewModelTest {

    private lateinit var viewModel: SplashViewModel
    private lateinit var navigator: Navigator

    @Before
    fun setup() = runTest {
        navigator = Navigator()
        viewModel = SplashViewModel(navigator)
    }

    @Test
    fun `create new account button has been pressed`() = runTest {
        viewModel.navigator.sharedFlow.test {
            viewModel.createNewAccountPressed()
            val routes = awaitItem()
            assertEquals(AuthRoutes.SignUp, routes)
        }
    }

    @Test
    fun `sign in button has been pressed`() = runTest {
        viewModel.navigator.sharedFlow.test {
            viewModel.signInPressed()
            val routes = awaitItem()
            assertEquals(AuthRoutes.SignIn, routes)
        }
    }

}