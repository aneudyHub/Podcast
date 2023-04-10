package com.example.podcast.di

import com.example.podcast.ui.navigation.Routes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNavigator() = Navigator()
}

class Navigator @Inject constructor() {
    private val _sharedFlow = MutableSharedFlow<Routes>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(routes: Routes) {
        _sharedFlow.tryEmit(routes)
    }
}