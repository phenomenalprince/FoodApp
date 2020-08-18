package com.wiki.gofood

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityLogin : AppCompatActivity() {

    lateinit var etMobileNo : EditText
    lateinit var etPassword : EditText

    lateinit var btnLogin : Button
    lateinit var txtForgot : TextView
    lateinit var txtCreateAccount : TextView

    private val validMobileNo = "0123456789"
    private val validPassword = "123456"

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_login)

        if (isLoggedIn)
        {
            val intent = Intent(this@ActivityLogin,ActivityAfterLogin::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"

        etMobileNo = findViewById(R.id.etMobileNo)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val mobileNo = etMobileNo.text.toString()
            val password = etPassword.text.toString()
            if (mobileNo == validMobileNo && password == validPassword)
            {
                savePreferences()
                var intent = Intent(this@ActivityLogin,ActivityAfterLogin::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this@ActivityLogin, "Invalid Credentials.", Toast.LENGTH_LONG).show()
            }
        }

        txtForgot = findViewById(R.id.txtForgot)
        txtForgot.setOnClickListener {
            var intent = Intent(this@ActivityLogin,ActivityForgotPassword::class.java)
            startActivity(intent)
        }

        txtCreateAccount = findViewById(R.id.txtCreateAccount)
        txtCreateAccount.setOnClickListener{
            var intent = Intent(this@ActivityLogin,ActivityToCreateAccount::class.java)
            startActivity(intent)
        }
    }

    private fun savePreferences(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }
}