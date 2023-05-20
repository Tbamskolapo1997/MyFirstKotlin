package com.example.myfirstprojecthelloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.buildSpannedString
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistrationActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    private lateinit var auth: FirebaseAuth
    lateinit var loginNowText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        button = findViewById(R.id.buttonRegister)

        etEmail = findViewById(R.id.etEmailReg)

        etPassword = findViewById(R.id.etPasswordReg)

        loginNowText = findViewById(R.id.tvLoginNow)


        loginNowText.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // Initialize Firebase Auth
        auth = Firebase.auth

        button.setOnClickListener {
            performSignUp()
        }



    }


    fun performSignUp() {

        if (etEmail.text.isEmpty() ||  etPassword.text.isEmpty()){
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val inputEmail = etEmail.text.toString()
        val inputPassword = etPassword.text.toString()


        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
//                        Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

//                        updateUI(user)

//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)

                    Toast.makeText(baseContext, "Success",
                        Toast.LENGTH_LONG).show()

                } else {

                    // If sign in fails, display a message to the user.
//                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed. ${task.exception?.message}",
                        Toast.LENGTH_LONG).show()
//                        updateUI(null)
                }
            }
            .addOnFailureListener {
                Toast.makeText( this, "Error occured ${it.localizedMessage}", Toast.LENGTH_LONG)
                    .show()
            }


    }






}