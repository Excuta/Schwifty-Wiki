package com.excuta.core.component.modules.picasso

import android.content.Context
import com.excuta.core.component.CoreScope
import com.excuta.core.component.modules.networkclient.NetworkClientModule
import com.squareup.picasso.Downloader
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [NetworkClientModule::class])
object PicassoModule {

    @JvmStatic
    @CoreScope
    @Provides
    fun downloader(okHttpClient: OkHttpClient): Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

    @JvmStatic
    @CoreScope
    @Provides
    fun picasso(appContext: Context, downloader: Downloader): Picasso {
        return Picasso.Builder(appContext)
            .downloader(downloader)
            .build()
    }
}