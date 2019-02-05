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
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val play2pause =
            AnimatedVectorDrawableCompat.create(applicationContext, R.drawable.play_to_pause_animation)
        val pause2play =
            AnimatedVectorDrawableCompat.create(applicationContext, R.drawable.pause_to_play_animation)
        message.setImageDrawable(play2pause)
        play2pause?.registerAnimationCallback(
            object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    super.onAnimationEnd(drawable)
                    handler.postDelayed({
                        message.setImageDrawable(pause2play)
                        pause2play?.start()
                    }, 200)
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
                    }, 200)
                }
            }
        )
        message.setOnClickListener {
            play2pause?.start()
        }
    }
}
