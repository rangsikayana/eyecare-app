package com.submission.eyecare.ui.fragments.test

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.eyecare.databinding.FragmentTestBinding
import com.submission.eyecare.ui.scan.ResultActivity

class TestFragment : Fragment() {
    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!
    private val historyViewModel: HistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = HistoryAdapter(arrayListOf()) { historyData ->
            // Handle delete button click
            historyViewModel.delete(historyData)
        }

        binding.historyRv.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.historyRv.adapter = adapter

        historyViewModel.allHistory.observe(viewLifecycleOwner, Observer { history ->
            history?.let { adapter.setData(ArrayList(it)) }
        })

        adapter.onItemClick = { historyData ->
            val intention = Intent(requireContext(), ResultActivity::class.java).apply {
                putExtra(ResultActivity.EXTRA_IMAGE_URI, historyData.img)
                putExtra(ResultActivity.EXTRA_CATEGORY, historyData.category)
                putExtra(ResultActivity.EXTRA_PERCENTAGE, historyData.percent)
                val imgUri = Uri.parse(historyData.img)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            }
            startActivity(intention)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
