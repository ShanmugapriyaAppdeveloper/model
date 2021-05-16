package com.example.modelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast


class LoginActivity : AppCompatActivity() {
        private lateinit var etEmail: EditText
        lateinit var  etPassword: EditText
        private val MIN_PASSWORD_LENGTH = 6

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            viewInitializations()
        }

        fun viewInitializations() {
            etEmail = findViewById(R.id.et_email)
            etPassword = findViewById(R.id.et_password)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        fun validateInput(): Boolean {
            if (etEmail.text.toString() == "") {
                etEmail.error = "Please Enter Email"
                return false
            }
            if (etPassword.text.toString() == "") {
                etPassword.error = "Please Enter Password"
                return false
            }

            if (!isEmailValid(etEmail.text.toString()))
            {
                etEmail.error = "Please Enter Valid Email"
                return false
            }


            if (etPassword.text.length < MIN_PASSWORD_LENGTH)
            {
                etPassword.error = "Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters"
                return false
            }
            return true
        }

        fun isEmailValid(email: String?): Boolean
        {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        fun performSignUp(v: View)
        {
            if (validateInput())
            {
                val email = etEmail!!.text.toString()
                val password = etPassword!!.text.toString()
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)


            }
        }

        fun goToSignup(v: View)
        {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }