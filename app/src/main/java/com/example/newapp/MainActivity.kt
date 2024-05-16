package com.example.newapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAllow: Button = findViewById(R.id.btnAllow)
        val btnShow: Button = findViewById(R.id.btnShow)
        val btnClose: Button = findViewById(R.id.btnClose)

        btnAllow.setOnClickListener {
            btnShow.isEnabled = true
        }

        btnShow.setOnClickListener {
            btnClose.visibility = View.VISIBLE
        }

        btnClose.setOnClickListener {
            finish()
        }
    }
}