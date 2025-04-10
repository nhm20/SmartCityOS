package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dashboard : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        findViewById<ImageButton>(R.id.volunteerOpportunities).setOnClickListener {
            val intent = Intent(this, VolunteerActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.TouristPlaces).setOnClickListener {
            val intent = Intent(this, TouristActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.Ambulance).setOnClickListener {
            val intent = Intent(this, EmergencyActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.Complaint).setOnClickListener {
            val intent = Intent(this, ComplaintActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.Traffic).setOnClickListener {
            val intent = Intent(this, TransportActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.EmergencyAlerts).setOnClickListener {
            val intent = Intent(this, EmergencyActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.Ambulance).setOnLongClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:112")
            startActivity(callIntent)
            true
        }

        findViewById<ImageButton>(R.id.Complaint).setOnLongClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW)
            webIntent.data = Uri.parse("https://bbmp.gov.in/")
            startActivity(webIntent)
            true
        }
    }
}