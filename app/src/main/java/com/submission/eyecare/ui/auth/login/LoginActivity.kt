package com.submission.eyecare.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.submission.eyecare.data.UserModel
import com.submission.eyecare.data.local.UserDisplayName
import com.submission.eyecare.databinding.ActivityLoginBinding
import com.submission.eyecare.ui.auth.register.RegisterActivity
import com.submission.eyecare.ui.custom.CustomMail
import com.submission.eyecare.ui.custom.CustomPassword
import com.submission.eyecare.ui.main.MainActivity
import com.submission.eyecare.utils.Result
import com.submission.eyecare.viewModels.VMFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var email: CustomMail
    private lateinit var pass: CustomPassword

    private val loginViewModel: LoginViewModel by viewModels {
        VMFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.apply {
            email =  emailEditText
            pass = passwordEditText
            btnLogin.setOnClickListener{
                retrieve()
            }
            tvRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }
    }
    private fun retrieve() {
        val emailResult = email.text.toString()
        val passResult = pass.text.toString()
        loginCredential(emailResult, passResult)
    }

    private fun loginCredential(
        email: String, pass: String
    ) {
        loginViewModel.login(email, pass).observe(this) { res ->
            if (res != null) {
                when (res){
                    is Result.Success -> {
                        val uid = res.data.uid.toString() // uid = token
                        val name = res.data.name.toString()
                        loginViewModel.saveSession(UserModel(email, uid))
                        loginViewModel.saveName(UserDisplayName(name))
                        isLoad(false)
                        setDialogOK()
                    }
                    is Result.Error -> {
                        showToast(res.error)
                        isLoad(false)
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
            setTitle("Success")
            setMessage("Login Credential confirmed, Continue?")
            setPositiveButton("Continue") { _, _ ->
                val intention = Intent(context, MainActivity::class.java)
                intention.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intention)
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