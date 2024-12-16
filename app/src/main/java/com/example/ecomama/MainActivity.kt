package com.example.ecomama

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val usernameInput: EditText = findViewById(R.id.username_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val loginBtn: Button = findViewById(R.id.login_btn)
        val registerBtn: Button = findViewById(R.id.register_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Logging login attempt
            Log.i("Text Credentials",  "Username : $username and Password : $password")

            if (username.isEmpty() || password.isEmpty()) {
                Log.w("LoginActivity", "Login failed: Empty username or password")
                Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Here you would typically do actual authentication
            // For now, just logging a simple login attempt
            if (username == "admin" && password == "password") {
                Log.i("LoginActivity", "Login successful for username: $username")
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                // Add navigation to next screen here
            } else {
                Log.e("LoginActivity", "Login failed: Invalid credentials")
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
            // Add redirect to registration page
            registerBtn.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            if (username == "admin" && password == "password") {
                // Login berhasil, buka halaman Profil
                val intent = Intent(this, BerandaActivity::class.java)
                startActivity(intent)
            } else {
                // Login gagal, tampilkan pesan error
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }




        }
    }
}