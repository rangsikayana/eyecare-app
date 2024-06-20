package com.submission.eyecare.ui.colorBlindTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import com.submission.eyecare.R
import com.submission.eyecare.databinding.ActivityColorTestBinding
import com.submission.eyecare.viewModels.VMFactory


class ColorTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityColorTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PlateListFragment())
                .commit()
        }
    }
}