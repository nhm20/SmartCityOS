package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val forgotPass = findViewById<TextView>(R.id.forgot_Pass)
        forgotPass.text = Html.fromHtml("<u>Forgot Password ?</u>", Html.FROM_HTML_MODE_LEGACY)

        val register = findViewById<TextView>(R.id.register)
        register.text = Html.fromHtml("<u>Register</u>", Html.FROM_HTML_MODE_LEGACY)
        register.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }

        val username = findViewById<EditText>(R.id.username)
        val pass = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.signin)
        login.setOnClickListener {
            val user = username.text.toString().trim()
            val password = pass.text.toString().trim()

            if (user == "username" && password == "password") {
                val intent = Intent(this@MainActivity, com.example.project.Services.Dashboard::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }





    }
}