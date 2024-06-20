package com.submission.eyecare.ui.auth.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.submission.eyecare.databinding.ActivityRegisterBinding
import com.submission.eyecare.ui.auth.login.LoginActivity
import com.submission.eyecare.ui.custom.CustomMail
import com.submission.eyecare.ui.custom.CustomName
import com.submission.eyecare.ui.custom.CustomPassword
import com.submission.eyecare.utils.Result
import com.submission.eyecare.viewModels.VMFactory

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private lateinit var firstName: CustomName
    private lateinit var lastName: CustomName
    private lateinit var email: CustomMail
    private lateinit var pass: CustomPassword

    private val registerViewModel: RegisterViewModel by viewModels {
        VMFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.apply {
            firstName = nameEditText
            lastName = LastNameEditText
            email = emailEditText
            pass = passwordEditText
            btnRegister.setOnClickListener{
                retrieve()
            }
        }

    }

    private fun retrieve() {
        val firstNameResult = firstName.text.toString()
        val lastNameResult = lastName.text.toString()
        val emailResult = email.text.toString()
        val passResult = pass.text.toString()
        registerCredential(firstNameResult,lastNameResult,emailResult, passResult)
    }

    private fun registerCredential(
        first: String, last: String,
        email: String, pass: String
    ) {
        registerViewModel.register(first, last, email, pass).observe(this) { res ->
            if (res != null) {
                when(res) {
                    is Result.Success -> {
                        isLoad(false)
                        showToast(res.data.toString())
                        setDialogOK()
                    }
                    is Result.Error -> {
                        isLoad(false)
                        showToast(res.error)
                    }
                    is Result.Loading -> {
                        isLoad(true)
                    }
                }
            }
        }
    }

    private fun setDialogOK() {
        AlertDialog.Builder(this).apply {
            setTitle("Congratulations")
            setMessage("Your Credential Have Been Registered")
            setPositiveButton("Continue") {_, _ ->
                val move = Intent(context, LoginActivity::class.java)
                move.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(move)
                finish()
            }
            create()
            show()
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun isLoad(load: Boolean) {
        binding.progressBar.visibility = if (load) View.VISIBLE else View.GONE
    }
}