package com.example.esercizio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun checkLogin(v: View?){
        val email: String = emailBox.getText().toString()
        if (!isValidEmail(email)) {
            //Set error message for email field
            emailBox.setError(getString(R.string.invalid_email))
        }
        val pass: String = passwordBox.getText().toString()
        if (!isValidPassword(pass)) {
            //Set error message for password field
            passwordBox.setError(getString(R.string.invalid_password))
        }
        if (isValidEmail(email) && isValidPassword(pass)) {
        // Validzione completata
        }

    }

    //Validazione email inserita
    private fun isValidEmail(email: String): Boolean {
        val EMAIL_PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    // Validazione password
    private fun isValidPassword(pass: String?): Boolean {
        return if (pass != null && pass.length >= 4) {
            true
        } else false
    }
}