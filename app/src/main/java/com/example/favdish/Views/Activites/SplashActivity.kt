package com.example.favdish.Views.Activites


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import androidx.appcompat.app.AppCompatActivity
import com.example.favdish.R
import com.example.favdish.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()


        val splashBinding:ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
        //splashBinding.textView.text = "hello world"

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{

            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        val splashAnimation= android.view.animation.AnimationUtils.loadAnimation(this , R.anim.anims)
                splashBinding.textView.animation = splashAnimation
        splashAnimation.setAnimationListener(object :AnimationListener{


            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
            override fun onAnimationEnd(animation: Animation?) {
Handler(Looper.getMainLooper()).postDelayed({
    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
    finish()
},2000)

            }
        })
    }
}