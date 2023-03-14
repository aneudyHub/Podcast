package com.example.podcast.viewmodels

import com.example.podcast.ui.navigation.AuthRoutes
import com.example.podcast.ui.viewmodels.SplashViewModel
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class SplashViewModelTest {

    @Inject
    lateinit var viewModel: SplashViewModel

    @Before
    fun setup() {
        viewModel = SplashViewModel()
    }

    @Test
    fun `create new account button has been pressed`() {
        assertNotNull(viewModel)
        viewModel.createNewAccountPressed()
        assertEquals(viewModel.navigation.value, AuthRoutes.SignUp)
    }

    @Test
    fun `sign in button has been pressed`() {
        assertNotNull(viewModel)
        viewModel.signInPressed()
        assertEquals(viewModel.navigation.value, AuthRoutes.SignIn)
    }

}