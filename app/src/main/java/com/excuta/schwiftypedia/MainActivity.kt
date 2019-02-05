package com.excuta.schwiftypedia

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        val duration = 100L
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val play2pause =
            AnimatedVectorDrawableCompat.create(applicationContext, R.drawable.r_to_m_animation)
        val pause2play =
            AnimatedVectorDrawableCompat.create(applicationContext, R.drawable.m_to_r_animation)
        message.setImageDrawable(play2pause)
        play2pause?.registerAnimationCallback(
            object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    super.onAnimationEnd(drawable)
                    handler.postDelayed({
                        message.setImageDrawable(pause2play)
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
                        message.setImageDrawable(play2pause)
                        play2pause?.start()
                    }, duration)
                }
            }
        )
        message.setOnClickListener {
            play2pause?.start()
        }
    }
}
