package com.excuta.core.component.modules.imageloader.contract

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes

interface ImageLoader {
    fun loadWithProgress(
        iv: ImageView,
        pb: ProgressBar,
        imageUrl: String,
        @DrawableRes loadingRes: Int,
        @DrawableRes errorRes: Int
    )

    fun loadWithProgress(
        iv: ImageView,
        pb: ProgressBar,
        imageUrl: String
    )

    fun loadWithoutProgress(
        iv: ImageView,
        imageUrl: String,
        @DrawableRes loadingRes: Int,
        @DrawableRes errorRes: Int
    )

    fun loadWithoutProgress(
        iv: ImageView,
        imageUrl: String
    )
}