package com.example.project

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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


    }
}