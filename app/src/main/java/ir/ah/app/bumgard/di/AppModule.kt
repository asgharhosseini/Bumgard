package ir.ah.app.bumgard.di

import android.content.*
import com.bumptech.glide.*

import com.bumptech.glide.load.engine.*
import com.bumptech.glide.load.resource.bitmap.*
import com.bumptech.glide.request.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.components.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.R
import javax.inject.*

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.logo)
            .error(R.drawable.logo)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(32)))
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )
}