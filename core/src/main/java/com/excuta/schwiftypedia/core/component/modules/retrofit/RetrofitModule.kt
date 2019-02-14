package com.excuta.schwiftypedia.core.component.modules.retrofit

import com.excuta.schwiftypedia.core.component.CoreScope
import com.iconcreations.modules.core.di.core.modules.networkclient.NetworkClientModule
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module(includes = [NetworkClientModule::class])
class RetrofitModule(
    private val converterFactory: Converter.Factory = GsonConverterFactory.create(),
    private val callAdapterFactory: CallAdapter.Factory = RxJava2CallAdapterFactory.create()
) {

    @CoreScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, @BaseUrl baseUrl: String): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converterFactory)
            .build()
    }
}

@Qualifier
annotation class BaseUrl