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
//            .placeholder(R.drawable.logointro)
//            .error(R.drawable.logointro)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(32)))
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )
}