package ir.ah.app.bumgard.di
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.ah.app.bumgard.BuildConfig
import ir.ah.app.bumgard.data.remote.*
import ir.ah.app.bumgard.data.repository.search.*
import ir.ah.app.bumgard.data.repository.search.dummy.*

import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    internal fun provideSearchRepository(apiService: ApiService): SearchRepository =
        if (BuildConfig.DEMO_MODE) DummySearchRepository() else SearchRepositoryImpl(apiService)


}