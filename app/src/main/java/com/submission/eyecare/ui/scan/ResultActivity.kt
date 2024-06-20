package com.submission.eyecare.ui.scan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.submission.eyecare.R
import com.submission.eyecare.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val img = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        val category = intent.getStringExtra(EXTRA_CATEGORY)
        val percentage = intent.getStringExtra(EXTRA_PERCENTAGE)
        val diagnosis = intent.getStringExtra(EXTRA_DIAGNOSIS)
        val treatment = intent.getStringExtra(EXTRA_TREATMENT)
        val food = intent.getStringExtra(EXTRA_FOOD)
        val vitamin = intent.getStringExtra(EXTRA_VITAMIN)

        runOnUiThread {
            img?.let {
               binding.resultImage.setImageURI(it)
            }
            category?.let {
                binding.tvCategory.text = it
            }
            percentage?.let {
                binding.tvPercentage.text = it
            }
            diagnosis?.let {
                binding.tvResult.text = it
            }
            treatment?.let {
                binding.tvEyetreatText.text = it
            }
            food?.let {
                binding.tvFoodText.text = it
            }
            vitamin?.let {
                binding.tvVitaminText.text = it
            }
        }
        binding.button.setOnClickListener{
            startActivity(Intent(this, ScanActivity::class.java))
            finish()
        }
    }

    companion object{
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_PERCENTAGE = "extra_percentage"
        const val EXTRA_DIAGNOSIS = "extra_diagnosis"
        const val EXTRA_TREATMENT = "extra_treatment"
        const val EXTRA_FOOD = "extra_food"
        const val EXTRA_VITAMIN = "extra_vitamin"

    }

}