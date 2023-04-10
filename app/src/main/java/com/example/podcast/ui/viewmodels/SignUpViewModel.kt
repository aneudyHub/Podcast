package com.example.podcast.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.podcast.R
import com.example.podcast.di.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    val navigator: Navigator
) : ViewModel() {
    private var _uiState = MutableStateFlow<UiState>(UiState())
    val uiState = _uiState.asStateFlow()

    fun setFullName(value: String) = updateState(_uiState.value.copy(fullName = value))
    fun setEmail(value: String) = updateState(_uiState.value.copy(email = value))
    fun setPassword(value: String) = updateState(_uiState.value.copy(password = value))

    private fun updateState(uiState: UiState) {
        val dataValidated = uiState.validateFormFields()
        val isCreateAccountEnabled = isCreateButtonEnabled(dataValidated)
        _uiState.update {
            dataValidated.copy(
                isCreateAccountEnabled = isCreateAccountEnabled
            )
        }
        println(_uiState.value.toString())
    }

    private fun isCreateButtonEnabled(uiState: UiState) =
        uiState.isTermPrivacyChecked
                && uiState.fullNameErrorResource == null
                && uiState.emailErrorResource == null
                && uiState.passwordErrorResource == null

    fun termsCheckPressed() =
        updateState(_uiState.value.copy(isTermPrivacyChecked = !_uiState.value.isTermPrivacyChecked))

    fun googleButtonPressed() {

    }

    fun facebookButtonPressed() {

    }

    fun createAccountButtonPressed() {

    }

    private fun isEmailValid(email: String): Boolean {
        val regex = Regex("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")
        return regex.matches(email)
    }

    private fun isPasswordValid(password: String): Boolean {
        val regex = Regex("^(?=.*?[A-Z])(?=.*?\\d)(?=.*?[^\\w\\s]).{8,}$")
        return regex.matches(password)
    }


    data class UiState(
        val isLoading: Boolean = false,
        val fullName: String = "",
        val fullNameErrorResource: Int? = null,
        val email: String = "",
        val emailErrorResource: Int? = null,
        val password: String = "",
        val passwordErrorResource: Int? = null,
        val isTermPrivacyChecked: Boolean = false,
        val isCreateAccountEnabled: Boolean = false
    )

    private fun UiState.validateFormFields(): UiState {
        val fullNameErrorHandlerResource = when {
            fullName.isEmpty() -> R.string.required
            else -> null
        }

        val emailErrorHandlerResource = when {
            email.isEmpty() -> R.string.required
            !isEmailValid(email) -> R.string.email_not_valid
            else -> null
        }

        val passwordErrorHandlerResource = when {
            !isPasswordValid(password) -> R.string.password_not_valid
            else -> null
        }

        return copy(
            fullNameErrorResource = fullNameErrorHandlerResource,
            emailErrorResource = emailErrorHandlerResource,
            passwordErrorResource = passwordErrorHandlerResource
        )
    }
}