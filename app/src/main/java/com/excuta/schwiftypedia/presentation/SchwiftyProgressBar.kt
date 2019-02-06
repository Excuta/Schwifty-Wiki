package com.excuta.schwiftypedia.presentation

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.excuta.schwiftypedia.R

class SchwiftyProgressBar : AppCompatImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        if (context != null) {
            val handler = Handler()
            val duration = 100L
            val play2pause =
                AnimatedVectorDrawableCompat.create(context, R.drawable.r_to_m_animation)
            val pause2play =
                AnimatedVectorDrawableCompat.create(context, R.drawable.m_to_r_animation)
            setImageDrawable(play2pause)
            play2pause?.registerAnimationCallback(
                object : Animatable2Compat.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        super.onAnimationEnd(drawable)
                        handler.postDelayed({
                            setImageDrawable(pause2play)
                            pause2play?.start()
                        }, duration)
                    }
                }
            )
            pause2play?.registerAnimationCallback(
                object : Animatable2Compat.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        super.onAnimationEnd(drawable)
                        handler.postDelayed({
                            setImageDrawable(play2pause)
                            play2pause?.start()
                        }, duration)
                    }
                }
            )
            play2pause?.start()
        }
    }

}