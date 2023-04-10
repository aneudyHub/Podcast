package com.example.podcast.viewmodels

import com.example.podcast.ui.viewmodels.SignUpViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import com.example.podcast.R
import com.example.podcast.di.Navigator

class SignUpViewModelTest {

    lateinit var viewModel: SignUpViewModel
    private lateinit var navigator: Navigator

    @Before
    fun setup() {
        navigator = Navigator()
        viewModel = SignUpViewModel(navigator)
    }

    @Test
    fun `full name shouldn't be blank or empty`() {
        viewModel.setFullName("")
        assertEquals(R.string.required, viewModel.uiState.value.fullNameErrorResource)

        viewModel.setFullName("Alex Kat")
        assertEquals(null, viewModel.uiState.value.fullNameErrorResource)
    }


    @Test
    fun `email should be valid`() {
        viewModel.setEmail("")
        assertEquals(R.string.required, viewModel.uiState.value.emailErrorResource)

        viewModel.setEmail("example.com")
        assertEquals(R.string.email_not_valid, viewModel.uiState.value.emailErrorResource)

        viewModel.setEmail("example@example")
        assertEquals(R.string.email_not_valid, viewModel.uiState.value.emailErrorResource)

        viewModel.setEmail("example@example.com")
        assertEquals(null, viewModel.uiState.value.emailErrorResource)
    }

    @Test
    fun `password should be valid`() {
        viewModel.setPassword("")
        assertEquals(R.string.password_not_valid, viewModel.uiState.value.passwordErrorResource)

        viewModel.setPassword("123456")
        assertEquals(R.string.password_not_valid, viewModel.uiState.value.passwordErrorResource)

        viewModel.setPassword("ABCDEFG")
        assertEquals(R.string.password_not_valid, viewModel.uiState.value.passwordErrorResource)

        viewModel.setPassword("Pa*w")
        assertEquals(R.string.password_not_valid, viewModel.uiState.value.passwordErrorResource)

        viewModel.setPassword("Pa*w0rd123")
        assertEquals(null, viewModel.uiState.value.passwordErrorResource)
    }

    @Test
    fun `create account button should be enabled once all fields are correct and agreed with terms`() {
        viewModel.setFullName("")
        viewModel.setPassword("Pa*w0rd123")
        viewModel.setEmail("example@example.com")
        viewModel.termsCheckPressed()
        assertEquals(false, viewModel.uiState.value.isCreateAccountEnabled)

        viewModel.termsCheckPressed()


        viewModel.setFullName("Alex Kat")
        viewModel.setPassword("Pa*w")
        viewModel.setEmail("example@example.com")
        viewModel.termsCheckPressed()
        assertEquals(false, viewModel.uiState.value.isCreateAccountEnabled)

        viewModel.termsCheckPressed()

        viewModel.setFullName("Alex Kat")
        viewModel.setPassword("Pa*w0rd123")
        viewModel.setEmail("example")
        viewModel.termsCheckPressed()
        assertEquals(false, viewModel.uiState.value.isCreateAccountEnabled)

        viewModel.termsCheckPressed()

        viewModel.setFullName("Alex Kat")
        viewModel.setPassword("Pa*w0rd123")
        viewModel.setEmail("example@example.com")
        viewModel.termsCheckPressed()
        assertEquals(true, viewModel.uiState.value.isCreateAccountEnabled)
    }
}