package com.submission.eyecare.ui.scan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.submission.eyecare.R
import com.submission.eyecare.data.network.ApiConfig
import com.submission.eyecare.databinding.ActivityScanBinding
import com.submission.eyecare.ui.fragments.home.HomeViewModel
import com.submission.eyecare.utils.getImageUri
import com.submission.eyecare.utils.reduceFileImage
import com.submission.eyecare.utils.showToast
import com.submission.eyecare.utils.uriToFile
import com.submission.eyecare.viewModels.VMFactory
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException

class ScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScanBinding
    private var currentImageUri: Uri? = null
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showToast(this, "Permission request granted")
            } else {
                showToast(this, "Permission request denied")
            }

        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    private val scanViewModel: ScanViewModel by viewModels {
        VMFactory.getInstance(this)
    }

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
//            currentImageUri?.let {
//                analyzeImage(it)
//            }
            uploadImage()
        }

        scanViewModel.uploadResult.observe(this, Observer { result ->
            result?.let {
                val category = it.predictedClass
                val confidence = it.confidence
                moveToResult(currentImageUri, category, confidence)
            }
        })

        scanViewModel.error.observe(this, Observer { error ->
            error?.let {
                showToast(it)
            }
        })

        scanViewModel.isLoading.observe(this, Observer { isLoading ->
            showLoading(isLoading)
        })


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

    private fun uploadImage() {
        currentImageUri?.let { uri ->
            val imageFile = uriToFile(uri, this).reduceFileImage()
            Log.d("Image Classification File", "showImage ${imageFile.path}")
            showLoading(true)

            val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
            val multipartBody = MultipartBody.Part.createFormData(
                "file",
                imageFile.name,
                requestImageFile
            )
            scanViewModel.uploadImage(multipartBody)
        } ?: showToast("Empty image")
    }


    private fun showLoading(isLoading: Boolean) {
        binding.progressIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

//    private fun analyzeImage(img: Uri) {
//        val category = getString(R.string.category)
//        val percentage = getString(R.string.percentage)
//        val diagnosis = getString(R.string.diagnosis)
//        val treatment = getString(R.string.treatment)
//        val food = getString(R.string.food)
//        val vitamins = getString(R.string.vitamins)
//        moveToResult(img, category, percentage, diagnosis, treatment, food, vitamins)
//    }

    private fun moveToResult(
        imgUri: Uri?, category: String,
        percent: Float,
    ) {
        val confidencePercentage = String.format("%.2f", percent).toDouble()
        val intention = Intent(this, ResultActivity::class.java)
        intention.putExtra(ResultActivity.EXTRA_IMAGE_URI, imgUri.toString())
        intention.putExtra(ResultActivity.EXTRA_CATEGORY, category)
        intention.putExtra(ResultActivity.EXTRA_PERCENTAGE, "$confidencePercentage%")
        startActivity(intention)
        finish()
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}