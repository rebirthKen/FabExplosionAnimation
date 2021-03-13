package com.example.fabexplosionanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.fabexplosionanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explosion_animation).apply {
            duration = 1000
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.fab.setOnClickListener {
            binding.fab.isVisible = false
            binding.circleView.isVisible = true
            binding.circleView.startAnimation(animation) {
                //todo you can display the view or whatever you want when the animation is done
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                binding.circleView.isVisible = false
                binding.textView.isVisible = true
            }
        }

    }


}