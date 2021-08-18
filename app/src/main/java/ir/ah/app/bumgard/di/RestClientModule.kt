package ir.ah.app.bumgard.di
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.ah.app.bumgard.data.remote.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestClientModule {

    @Provides
    @Singleton
    internal fun provideApiService(
        @BumgardRetrofit retrofit: Retrofit
    ): ApiService = retrofit.create(ApiService::class.java)





    @Provides
    @BumgardRetrofit
    @Singleton
    internal fun provideHiCityRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .baseUrl(EndPoints.STAGE_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BumgardRetrofit