package com.submission.eyecare.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import com.submission.eyecare.databinding.ActivitySplashBinding
import com.submission.eyecare.ui.auth.login.LoginActivity
import com.submission.eyecare.ui.main.MainActivity
import com.submission.eyecare.viewModels.VMFactory

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val splashModel: SplashViewModel by viewModels {
        VMFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.container.alpha = 0f
        binding.container.animate().setDuration(2000).alpha(1f).withEndAction{
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            splashModel.fetchSession().observe(this) { check ->
                val move = if (check.isLogin) {
                    Intent(this, MainActivity::class.java)
                } else {
                    Intent(this, LoginActivity::class.java)
                }
                startActivity(move)
                finish()
            }
        }

        splashModel.getTheme().observe(this) { isDark: Boolean ->
            if (isDark) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
       /* splashModel.fetchSession().observe(this) { check ->
            val move = if (check.isLogin) {
                Intent(this, MainActivity::class.java)
            } else {
                Intent(this, LoginActivity::class.java)
            }
            startActivity(move)
            finish()
        }*/

    }
}