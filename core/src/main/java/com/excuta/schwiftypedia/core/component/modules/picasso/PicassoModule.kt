package com.excuta.schwiftypedia.core.component.modules.picasso

import android.content.Context
import com.excuta.schwiftypedia.core.component.CoreScope
import com.iconcreations.modules.core.di.core.modules.networkclient.NetworkClientModule
import com.squareup.picasso.Downloader
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [NetworkClientModule::class])
class PicassoModule {

    @CoreScope
    @Provides
    fun downloader(okHttpClient: OkHttpClient): Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

    @CoreScope
    @Provides
    fun picasso(appContext: Context, downloader: Downloader): Picasso {
        return Picasso.Builder(appContext)
            .downloader(downloader)
            .build()
    }
}