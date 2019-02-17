package com.excuta.core.component.modules.retrofit

import com.excuta.core.component.CoreScope
import com.iconcreations.modules.core.di.core.modules.networkclient.NetworkClientModule
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module(includes = [NetworkClientModule::class])
object RetrofitModule {

    @JvmStatic
    @CoreScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, @BaseUrl baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

@Qualifier
annotation class BaseUrl