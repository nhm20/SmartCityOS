package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EmergencyActivity : AppCompatActivity() {

    private val emergencyContact = "1234567890"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        val btnCallPolice: Button = findViewById(R.id.btnCallPolice)
        val btnCallAmbulance: Button = findViewById(R.id.btnCallAmbulance)
        val btnOpenMaps: Button = findViewById(R.id.btnOpenMaps)
        val btnSendAlert: Button = findViewById(R.id.btnSendAlert)

        btnCallPolice.setOnClickListener { makePhoneCall("100") }
        btnCallAmbulance.setOnClickListener { makePhoneCall("108") }
        btnOpenMaps.setOnClickListener { openMaps() }
        btnSendAlert.setOnClickListener { checkAndSendSMS() }
    }

    private fun makePhoneCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }

    private fun openMaps() {
        val gmmIntentUri = Uri.parse("geo:0,0?q=hospital")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private fun checkAndSendSMS() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
//            != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 1)
//        } else {
//            sendEmergencySMS()
//        }
//        <uses-permission android:name="android.permission.CALL_PHONE" />
//        <uses-permission android:name="android.permission.SEND_SMS" />
//        <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>

    }

    private fun sendEmergencySMS() {
        val message = "Emergency! I need help at my location!"
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(emergencyContact, null, message, null, null)
            Toast.makeText(this, "Emergency Alert Sent!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Failed to send alert", Toast.LENGTH_SHORT).show()
        }
    }
}
