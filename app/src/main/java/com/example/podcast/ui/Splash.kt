package com.example.podcast.ui

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.podcast.ui.theme.PodcastTheme
import com.example.podcast.R

class Splash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            PodcastTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    // A surface container using the 'background' color from the theme
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
fun BottomContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
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
            Box(modifier = Modifier.fillMaxWidth().padding(top = 32.dp)){
                Column {
                    RoundedPositiveButton(
                        modifier = Modifier.padding(16.dp),
                        textResource = R.string.new_account
                    ) {
                        Log.e("ANEUDY", "Click ....... ")
                    }
                    TertiaryButton(
                        modifier = Modifier.padding(8.dp),
                        textResource = R.string.sign_in,
                        color = MaterialTheme.colors.onBackground
                    ) {
                        Log.e("ANEUDY", "Click ....... ")
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PodcastTheme {
        Content()
    }
}