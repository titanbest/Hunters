package com.titanium.hunters.view.activities

import android.content.Intent
import android.os.Bundle
import com.titanium.hunters.view.base.BaseActivity
import com.titanium.hunters.R

class SplashScreenActivity : BaseActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startGame()
    }

    private fun startGame() = this.let {
        startActivity(Intent(it, MainActivity::class.java))
        finish()
    }
}