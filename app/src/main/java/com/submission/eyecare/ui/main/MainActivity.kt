package com.submission.eyecare.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.submission.eyecare.R
import com.submission.eyecare.databinding.ActivityMainBinding
import com.submission.eyecare.ui.auth.login.LoginActivity
import com.submission.eyecare.ui.auth.register.RegisterActivity
import com.submission.eyecare.ui.colorBlindTest.ColorTestActivity
import com.submission.eyecare.ui.profile.ProfileActivity
import com.submission.eyecare.ui.scan.ScanActivity
import com.submission.eyecare.viewModels.MainViewModels
import com.submission.eyecare.viewModels.VMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModels by viewModels {
        VMFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        // Setup Navigation
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_medication,
                R.id.navigation_dashboard,
                R.id.navigation_History,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
}