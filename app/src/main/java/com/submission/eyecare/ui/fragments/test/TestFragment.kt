package com.submission.eyecare.ui.fragments.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.submission.eyecare.R
import com.submission.eyecare.data.dummy.HistoryAdapter
import com.submission.eyecare.data.dummy.HistoryData
import com.submission.eyecare.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!
    private val itemList =  ArrayList<HistoryData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTestBinding.inflate(inflater, container, false)
        val root: View = binding.root

        if (itemList.isEmpty()) {
            itemList.addAll(getData())
        }
        setup()


        return root
    }

    private fun setup() {
        val rv = binding.historyRv
        val hisAdapter = HistoryAdapter(itemList)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv.adapter = hisAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getData(): ArrayList<HistoryData> {
        val dataDiseases = resources.getStringArray(R.array.dummy_category)
        val dataDesc = resources.getStringArray(R.array.dummy_percentage)
        val dataPhoto = resources.obtainTypedArray(R.array.dummy_img)
        val listHistory = ArrayList<HistoryData>()
        for (i in dataDiseases.indices) {
            val item = HistoryData(dataPhoto.getResourceId(i, -1), dataDiseases[i], dataDesc[i])
            listHistory.add(item)
        }
        return listHistory
    }
}