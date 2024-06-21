package com.submission.eyecare.ui.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.submission.eyecare.R
import com.submission.eyecare.adapter.DiseaseAdapter
import com.submission.eyecare.data.local.Diseases
import com.submission.eyecare.databinding.FragmentHomeBinding
import com.submission.eyecare.ui.auth.login.LoginActivity
import com.submission.eyecare.ui.auth.register.RegisterActivity
import com.submission.eyecare.ui.colorBlindTest.ColorTestActivity
import com.submission.eyecare.ui.scan.ScanActivity
import com.submission.eyecare.viewModels.VMFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val itemList =  ArrayList<Diseases>()
    private val disAdapter = DiseaseAdapter(itemList)

    private val homeViewModel: HomeViewModel by viewModels {
        VMFactory.getInstance(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        if (itemList.isEmpty()) {
            itemList.addAll(getData())
        }
        setup()

        homeViewModel.fetchName().observe(viewLifecycleOwner) {name ->
            val name = name.displayName
            binding.name.text = name
        }

        binding.btnTest.setOnClickListener{
            startActivity(Intent(requireActivity(), ColorTestActivity::class.java))
        }

        binding.btnAnalyze.setOnClickListener{
            startActivity(Intent(requireActivity(), ScanActivity::class.java))
        }

        binding.btnCart.setOnClickListener{
            Toast.makeText(requireContext(), "Additional feature in the future", Toast.LENGTH_SHORT).show()
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun setup() {
        val rv = binding.DiseaseRv
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv.adapter = disAdapter
    }
    private fun getData(): ArrayList<Diseases> {
        val dataDiseases = resources.getStringArray(R.array.data_disease)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.getStringArray(R.array.data_icon)
        val listDis = ArrayList<Diseases>()
        for (i in dataDiseases.indices) {
            val item  = Diseases(dataDiseases[i], dataDesc[i], dataPhoto[i])
            listDis.add(item)
        }
        return listDis
    }

}