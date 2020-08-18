package com.wiki.gofood

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ActivityForgotPassword : AppCompatActivity() {

    lateinit var etMobile : EditText
    lateinit var otp : EditText
    lateinit var btnRecover : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        title = "Recover Password"

        etMobile = findViewById(R.id.etForgotMobileNo)
        otp = findViewById(R.id.etOTP)
        btnRecover = findViewById(R.id.btnRecoverPassword)

        btnRecover.setOnClickListener {
            val mobile = etMobile.text.toString()
            if (mobile == "" || mobile.length < 10)
            {
                Toast.makeText(this@ActivityForgotPassword,"Enter Correct Mobile No.",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this@ActivityForgotPassword,"Wait for OTP...",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}