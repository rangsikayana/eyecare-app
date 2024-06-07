package com.submission.eyecare.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import com.submission.eyecare.R
import com.submission.eyecare.data.UserPreference
import com.submission.eyecare.data.dataStore
import com.submission.eyecare.databinding.ActivityProfileBinding
import com.submission.eyecare.ui.main.MainActivity
import com.submission.eyecare.viewModels.ProfileViewModel
import com.submission.eyecare.viewModels.VMFactory

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private val profileViewModel: ProfileViewModel by viewModels {
        VMFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //test
        binding.profileCard.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        //setup Dark Mode
        profileViewModel.getTheme().observe(this) { isDark: Boolean ->
            if (isDark) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.themeSwitch.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.themeSwitch.isChecked = false
            }
        }
        binding.themeSwitch.setOnCheckedChangeListener{ _: CompoundButton?, isChecked: Boolean ->
            profileViewModel.saveTheme(isChecked)
        }

    }
}