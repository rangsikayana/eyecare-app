package com.submission.eyecare.ui.fragments.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.submission.eyecare.databinding.FragmentNotificationsBinding
import com.submission.eyecare.ui.auth.login.LoginActivity
import com.submission.eyecare.viewModels.VMFactory

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null


    private val binding get() = _binding!!
    private val notificationsViewModel: NotificationsViewModel by viewModels {
        VMFactory.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        notificationsViewModel.fetchName().observe(viewLifecycleOwner) {name ->
            val uname = name.displayName
            binding.display.text = uname
        }

        notificationsViewModel.getTheme().observe(viewLifecycleOwner) { isDark: Boolean ->
            if (isDark) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.themeSwitch.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.themeSwitch.isChecked = false
            }
        }
        binding.themeSwitch.setOnCheckedChangeListener{ _: CompoundButton?, isChecked: Boolean ->
            notificationsViewModel.saveTheme(isChecked)
        }

        binding.logoutCard.setOnClickListener{
            setDialogOut()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setDialogOut() {
        AlertDialog.Builder(requireActivity()).apply {
            setTitle("Logging Out")
            setMessage("Confirm Logout?")
            setPositiveButton("Logout") {_, _ ->
                notificationsViewModel.logout()
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
                activity?.finish()
            }
            setNegativeButton("Nope")  {dial, _ ->
                dial.dismiss()
            }
            create()
            show()
        }
    }
}