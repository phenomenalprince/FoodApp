@file:Suppress("DEPRECATION")

package com.wiki.gofood

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
            {
                val intent = Intent(this@SplashActivity, ActivityLogin::class.java)
                startActivity(intent)
            }, 2000
        )
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
