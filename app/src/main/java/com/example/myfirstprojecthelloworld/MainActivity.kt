package com.example.myfirstprojecthelloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var signUpText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signUpText = findViewById(R.id.tvSignUPbutton)


        signUpText.setOnClickListener {
            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }

    }

    fun signInClick(view: View) {
        var intent = Intent(this,Home_screen::class.java)
        startActivity(intent)
    }

    fun forgetPassword(view: View) {
        var intent = Intent(this,ForgetPassword::class.java)
        startActivity(intent)
    }


}