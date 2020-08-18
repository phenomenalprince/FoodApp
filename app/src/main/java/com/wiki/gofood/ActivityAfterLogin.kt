package com.wiki.gofood

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityAfterLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)
        title = "Welcome back!"
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}