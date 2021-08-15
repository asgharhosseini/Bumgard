package ir.ah.app.bumgard.di

import dagger.*
import dagger.hilt.*
import dagger.hilt.components.*
import kotlinx.coroutines.*
import javax.inject.*

@InstallIn(SingletonComponent::class)
@Module
object DispatcherModule {

    @Singleton
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}