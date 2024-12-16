package com.example.ecomama

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Find views
        val fullnameInput: EditText = findViewById(R.id.fullname_input)
        val emailInput: EditText = findViewById(R.id.email_input)
        val usernameInput: EditText = findViewById(R.id.username_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val confirmPasswordInput: EditText = findViewById(R.id.confirm_password_input)
        val registerBtn: Button = findViewById(R.id.register_btn)
        val loginRedirect: TextView = findViewById(R.id.login_redirect)

        // Register button click listener
        registerBtn.setOnClickListener {
            val fullname = fullnameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString()
            val confirmPassword = confirmPasswordInput.text.toString()

            // Validation
            if (validateRegistration(fullname, email, username, password, confirmPassword)) {
                // Perform registration logic
                registerUser(fullname, email, username, password)
            }
        }

        // Redirect to login
        loginRedirect.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateRegistration(
        fullname: String,
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        // Fullname validation
        if (fullname.isEmpty()) {
            Toast.makeText(this, "Full Name cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }

        // Email validation
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            return false
        }

        // Username validation
        if (username.isEmpty() || username.length < 4) {
            Toast.makeText(this, "Username must be at least 4 characters", Toast.LENGTH_SHORT).show()
            return false
        }

        // Password validation
        if (password.isEmpty() || password.length < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            return false
        }

        // Confirm password validation
        if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun registerUser(fullname: String, email: String, username: String, password: String) {
        // Logging registration attempt
        Log.i("RegisterActivity", "Registration attempt for username: $username")



        // Simulated successful registration
        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()

        // Optional: Redirect to login or main activity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()


    }


}

