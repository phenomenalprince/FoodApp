package com.wiki.gofood

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ActivityToCreateAccount : AppCompatActivity() {

    lateinit var btnRegister : Button
    lateinit var etFirstName : EditText
    lateinit var etLastName : EditText
    lateinit var etMobileNo : EditText
    lateinit var etPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        title = "Create Account"

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etMobileNo = findViewById(R.id.etRegisterNumber)
        etPassword = findViewById(R.id.etRegisterPassword)
        btnRegister = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val mobile = etMobileNo.text.toString()
            val password = etPassword.text.toString()
            if (firstName == "" || lastName == "" || mobile == "" || password == "")
            {
                Toast.makeText(this@ActivityToCreateAccount,"Fill all Credentials.",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@ActivityToCreateAccount,ActivityAfterRegistration::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}