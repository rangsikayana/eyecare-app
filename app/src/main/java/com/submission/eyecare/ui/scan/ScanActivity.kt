package com.submission.eyecare.ui.scan

import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.submission.eyecare.databinding.ActivityScanBinding
import android.Manifest
import android.content.Intent
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import com.submission.eyecare.R
import com.submission.eyecare.utils.getImageUri
import com.submission.eyecare.utils.showToast

class ScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScanBinding
    private var currentImageUri: Uri? = null
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showToast(this,"Permission request granted")
            } else {
                showToast(this,"Permission request denied")
            }

        }
    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }

        binding.btnGallery.setOnClickListener { startGallery() }
        binding.btnCamera.setOnClickListener { startCamera() }
        //setup for dummy data
        binding.btnAnalyze.setOnClickListener {
//            need to do
            currentImageUri?.let {
                analyzeImage(it)
            }
        }

    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }

    }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.ivPreview.setImageURI(it)
        }
    }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherIntentCamera.launch(currentImageUri!!)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        }
    }


    private fun analyzeImage(img: Uri) {
        val category = getString(R.string.category)
        val percentage = getString(R.string.percentage)
        val diagnosis = getString(R.string.diagnosis)
        val treatment = getString(R.string.treatment)
        val food = getString(R.string.food)
        val vitamins = getString(R.string.vitamins)
        moveToResult(img, category, percentage, diagnosis, treatment, food, vitamins)
    }

    private fun moveToResult(
        imgUri: Uri?, category: String,
        percent: String,
        diagnosis: String, treatment: String,
        food: String, vitamins: String ) {
        val intention = Intent(this, ResultActivity::class.java)
        intention.putExtra(ResultActivity.EXTRA_IMAGE_URI, imgUri.toString())
        intention.putExtra(ResultActivity.EXTRA_CATEGORY, category)
        intention.putExtra(ResultActivity.EXTRA_PERCENTAGE, percent)
        intention.putExtra(ResultActivity.EXTRA_DIAGNOSIS, diagnosis)
        intention.putExtra(ResultActivity.EXTRA_TREATMENT, treatment)
        intention.putExtra(ResultActivity.EXTRA_FOOD, food)
        intention.putExtra(ResultActivity.EXTRA_VITAMIN, vitamins)
        startActivity(intention)
        finish()
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}