package com.excuta.schwiftypedia.core.component

import android.content.Context
import com.excuta.schwiftypedia.core.component.modules.imageloader.ImageLoaderModule
import com.excuta.schwiftypedia.core.component.modules.imageloader.PicassoImageLoader
import com.excuta.schwiftypedia.core.component.modules.imageloader.contract.ImageLoader
import com.excuta.schwiftypedia.core.component.modules.retrofit.BaseUrl
import com.excuta.schwiftypedia.core.component.modules.retrofit.RetrofitModule
import com.iconcreations.modules.core.di.core.modules.networkclient.NetworkTag
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Scope

@CoreScope
@Component(modules = [RetrofitModule::class, ImageLoaderModule::class])
interface CoreComponent {
	fun picassoLoader(): @PicassoImageLoader ImageLoader
	fun retrofit(): Retrofit

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun retrofitBaseUrl(@BaseUrl baseUrl: String): Builder

		@BindsInstance
		fun appContext(context: Context): Builder

		@BindsInstance
		fun loggingNetworkTag(@NetworkTag networkTag: String): Builder

		fun build(): CoreComponent
	}
}

@Scope
annotation class CoreScope