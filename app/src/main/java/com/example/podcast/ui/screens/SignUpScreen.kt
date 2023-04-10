package com.example.podcast.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.podcast.R
import com.example.podcast.ui.FacebookButton
import com.example.podcast.ui.GoogleButton
import com.example.podcast.ui.RoundedPositiveButton
import com.example.podcast.ui.components.EditText
import com.example.podcast.ui.viewmodels.SignUpViewModel


@Composable
@Preview
fun SignUpScreen(viewModel: SignUpViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 45.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text = stringResource(id = R.string.new_account),
                style = MaterialTheme.typography.h5
            )

            SignUpForm(
                uiState.fullName,
                uiState.fullNameErrorResource,
                uiState.email,
                uiState.emailErrorResource,
                uiState.password,
                uiState.passwordErrorResource,
                fullNameOnChangedListener = {
                    viewModel.setFullName(it)
                },
                emailOnChangedListener = {
                    viewModel.setEmail(it)
                },
                passwordOnChangedListener = {
                    viewModel.setPassword(it)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = uiState.isTermPrivacyChecked,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primary,
                        checkmarkColor = MaterialTheme.colors.onSurface
                    ),
                    onCheckedChange = {
                        viewModel.termsCheckPressed()
                    }
                )
                Text(text = stringResource(id = R.string.agree_terms_privacy))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = R.string.or))
            }

            Spacer(modifier = Modifier.size(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier.weight(1f)) {
                    GoogleButton {
                        viewModel.googleButtonPressed()
                    }
                }
                Spacer(modifier = Modifier.size(8.dp))
                Box(modifier = Modifier.weight(1f)) {
                    FacebookButton {
                        viewModel.facebookButtonPressed()
                    }
                }
            }

            Spacer(modifier = Modifier.size(150.dp))

            RoundedPositiveButton(
                textResource = R.string.new_account,
                isEnabled = uiState.isCreateAccountEnabled
            ) {
                viewModel.createAccountButtonPressed()
            }

        }
    }
}

@Composable
fun SignUpForm(
    fullName: String,
    fullNameError: Int?,
    email: String,
    emailError: Int?,
    password: String,
    passwordError: Int?,
    fullNameOnChangedListener: (String) -> Unit,
    emailOnChangedListener: (String) -> Unit,
    passwordOnChangedListener: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        EditText(
            titleResource = R.string.full_name_label,
            placeHolderResource = R.string.full_name_placeholder,
            value = fullName,
            keyboardOptions = KeyboardOptions.Default,
            leadingIcon = {
                Icon(Icons.Filled.Person, contentDescription = "")
            },
            onErrorResource = fullNameError,
            onChangedListener = {
                fullNameOnChangedListener(it)
            })

        EditText(
            titleResource = R.string.email_label,
            placeHolderResource = R.string.email_placeholder,
            value = email,
            keyboardOptions = KeyboardOptions.Default,
            leadingIcon = {
                Icon(Icons.Filled.Email, contentDescription = "")
            },
            onErrorResource = emailError,
            onChangedListener = {
                emailOnChangedListener(it)
            })

        EditText(
            titleResource = R.string.password_label,
            value = password,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(Icons.Filled.Lock, contentDescription = "")
            },
            onErrorResource = passwordError,
            onChangedListener = {
                passwordOnChangedListener(it)
            })

    }
}