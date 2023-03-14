package com.example.podcast.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.example.podcast.ui.theme.PodcastTheme
import com.example.podcast.ui.viewmodels.NavigationViewModel


abstract class BaseActivity : ComponentActivity() {

    protected val navViewModel: NavigationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            PodcastTheme {
                BaseContentContainer()
            }
        }
    }

    @Composable
    abstract fun BaseContentContainer()
}