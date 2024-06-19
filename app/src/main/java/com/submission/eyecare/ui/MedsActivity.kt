package com.submission.eyecare.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.submission.eyecare.R
import com.submission.eyecare.databinding.ActivityMedsBinding

class MedsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMedsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra(EXTRA_NAME)
        val overview = intent.getStringExtra(EXTRA_OVERVIEW)
        val about = intent.getStringExtra(EXTRA_ABOUT)
        val url = intent.getStringExtra(EXTRA_URL)

        binding.apply {
            medsHeader.text = name
            benefitContent.text = overview
            aboutContent.text = about
            Glide.with(this@MedsActivity)
                .load(url)
                .into(imgMeds)
        }

    }


    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_ABOUT = "extra_img"
        const val EXTRA_URL = "extra_url"
    }
}