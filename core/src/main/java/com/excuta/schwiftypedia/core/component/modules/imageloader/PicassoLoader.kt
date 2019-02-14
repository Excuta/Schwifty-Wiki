package com.excuta.schwiftypedia.core.component.modules.imageloader

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.excuta.schwiftypedia.core.component.modules.imageloader.contract.ImageLoader
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import javax.inject.Qualifier

internal class PicassoLoader(private val picasso: Picasso) :
    ImageLoader {

    override fun loadWithProgress(iv: ImageView, pb: ProgressBar, imageUrl: String, loadingRes: Int, errorRes: Int) {
        pb.visibility = View.VISIBLE
        picasso.load(imageUrl).placeholder(loadingRes).error(errorRes).into(iv, object : Callback {
            override fun onSuccess() {
                pb.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                pb.visibility = View.GONE
            }
        })
    }

    override fun loadWithProgress(iv: ImageView, pb: ProgressBar, imageUrl: String) {
        pb.visibility = View.VISIBLE
        picasso.load(imageUrl).into(iv, object : Callback {
            override fun onSuccess() {
                pb.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                pb.visibility = View.GONE
            }
        })
    }

    override fun loadWithoutProgress(iv: ImageView, imageUrl: String, loadingRes: Int, errorRes: Int) {
        picasso.load(imageUrl).placeholder(loadingRes).error(errorRes).into(iv)
    }

    override fun loadWithoutProgress(iv: ImageView, imageUrl: String) {
        picasso.load(imageUrl).into(iv)
    }
}

@Target(AnnotationTarget.TYPE)
@Qualifier
internal annotation class PicassoImageLoader