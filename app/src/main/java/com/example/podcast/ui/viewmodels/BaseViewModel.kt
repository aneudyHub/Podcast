package com.example.podcast.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.podcast.ui.navigation.EmptyRoute
import com.example.podcast.ui.navigation.Routes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


abstract class BaseViewModel : ViewModel() {
    private val _navigation = MutableStateFlow<Routes>(EmptyRoute)
    val navigation = _navigation.asStateFlow()

    fun navigate(navRoute: Routes) {
        _navigation.value = navRoute
    }

}