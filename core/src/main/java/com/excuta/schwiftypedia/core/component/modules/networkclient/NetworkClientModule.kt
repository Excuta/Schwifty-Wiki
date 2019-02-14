package com.iconcreations.modules.core.di.core.modules.networkclient

import com.excuta.schwiftypedia.core.component.CoreScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Qualifier

@Module
class NetworkClientModule {

    @CoreScope
    @Provides
    fun httpLogginInterceptor(@NetworkTag networkTag: String): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            val log = "$networkTag $it"
            Timber.d(log)
        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return httpLoggingInterceptor
    }

    @CoreScope
    @Provides
    fun okHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}

@Qualifier
annotation class NetworkTag