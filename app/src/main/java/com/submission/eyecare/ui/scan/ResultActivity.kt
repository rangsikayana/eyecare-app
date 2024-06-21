package com.submission.eyecare.ui.scan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.submission.eyecare.databinding.ActivityResultBinding
import java.io.File

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val imgUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        val imgFile = imgUriString?.let { File(it) }
        val category = intent.getStringExtra(EXTRA_CATEGORY)
        val percentage = intent.getStringExtra(EXTRA_PERCENTAGE)

        runOnUiThread {
            if (imgFile?.exists() == true) {
                Glide.with(this)
                    .load(imgFile)
                    .into(binding.resultImage)
            } else {
                imgUriString?.let {
                    Glide.with(this)
                        .load(Uri.parse(it))
                        .into(binding.resultImage)
                }
            }
            category?.let {
                binding.tvCategory.text = it
            }
            percentage?.let {
                binding.tvPercentage.text = it
            }
        }
        binding.button.setOnClickListener {
            startActivity(Intent(this, ScanActivity::class.java))
            finish()
        }
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_PERCENTAGE = "extra_percentage"
    }
}
