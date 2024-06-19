package com.submission.eyecare.ui.fragments.test

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.submission.eyecare.R
import com.submission.eyecare.adapter.DiseaseAdapter
import com.submission.eyecare.data.local.Diseases
import com.submission.eyecare.databinding.FragmentHomeBinding
import com.submission.eyecare.databinding.FragmentTestBinding
import com.submission.eyecare.ui.colorBlindTest.ColorTestActivity

class TestFragment : Fragment() {
    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTestBinding.inflate(inflater, container, false)
        val root: View = binding.root

       /* binding.colorTest.setOnClickListener{
            startActivity(Intent(requireActivity(), ColorTestActivity::class.java))
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}