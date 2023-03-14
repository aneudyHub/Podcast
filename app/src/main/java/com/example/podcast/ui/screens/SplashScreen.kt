package com.example.podcast.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.podcast.R
import com.example.podcast.ui.RoundedPositiveButton
import com.example.podcast.ui.TertiaryButton
import com.example.podcast.ui.viewmodels.SplashViewModel


@Composable
fun SplashScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                SplashPicture()
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                BottomContent()
            }
        }
    }
}

@Composable
fun BottomContent(viewModel: SplashViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.splash_title),
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.splash_subtitle),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 16.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Column {
                    RoundedPositiveButton(
                        modifier = Modifier.padding(16.dp),
                        textResource = R.string.new_account
                    ) {
                        viewModel.createNewAccountPressed()
                    }
                    TertiaryButton(
                        modifier = Modifier.padding(8.dp),
                        textResource = R.string.sign_in,
                        color = MaterialTheme.colors.onBackground
                    ) {
                        viewModel.signInPressed()
                    }
                }
            }

        }
    }
}

@Composable
fun SplashPicture() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.grafic),
            contentDescription = ""
        )

    }
}