package com.example.flipcardanimation
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flipcardanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding
    lateinit var back_anim: AnimatorSet
    lateinit var front_anim: AnimatorSet
    var isFront = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)

        val scale: Float = applicationContext.resources.displayMetrics.density

        bindingMainActivity.cardFront.cameraDistance = 8000 * scale
        bindingMainActivity.cardBack.cameraDistance = 8000 * scale

        front_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.front_animator) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.back_animator) as AnimatorSet

        bindingMainActivity.btnFlip.setOnClickListener {
            if(isFront){
                front_anim.setTarget(bindingMainActivity.cardFront)
                back_anim.setTarget(bindingMainActivity.cardBack)
                front_anim.start()
                back_anim.start()
                isFront = false
            }else{
                front_anim.setTarget(bindingMainActivity.cardBack)
                back_anim.setTarget(bindingMainActivity.cardFront)
                front_anim.start()
                back_anim.start()
                isFront = true
            }
        }
    }
}