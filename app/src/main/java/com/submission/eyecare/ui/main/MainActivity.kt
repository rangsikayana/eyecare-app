package com.submission.eyecare.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.submission.eyecare.databinding.ActivityMainBinding
import com.submission.eyecare.ui.auth.login.LoginActivity
import com.submission.eyecare.ui.auth.register.RegisterActivity
import com.submission.eyecare.ui.profile.ProfileActivity
import com.submission.eyecare.ui.scan.ScanActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// Sementara
        binding.login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.analyze.setOnClickListener {
            val intent = Intent(this, ScanActivity::class.java)
            startActivity(intent)
        }

        binding.profile.setOnClickListener{
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        binding.analyzeFeature.setOnClickListener{
            val intent = Intent(this, ScanActivity::class.java)
            startActivity(intent)
        }
        binding.profileFeature.setOnClickListener{
            startActivity(Intent(this, ProfileActivity::class.java))
        }
// Sementara

    }
}