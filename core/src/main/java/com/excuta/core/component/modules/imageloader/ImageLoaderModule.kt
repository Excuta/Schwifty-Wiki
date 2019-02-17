package com.excuta.core.component.modules.imageloader

import com.excuta.core.component.CoreScope
import com.excuta.core.component.modules.imageloader.contract.ImageLoader
import com.excuta.core.component.modules.picasso.PicassoModule
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module(includes = [PicassoModule::class])
object ImageLoaderModule {
    @JvmStatic
    @CoreScope
    @Provides
    fun picassoLoader(picasso: Picasso): @PicassoImageLoader ImageLoader {
        return PicassoLoader(picasso)
    }
}


