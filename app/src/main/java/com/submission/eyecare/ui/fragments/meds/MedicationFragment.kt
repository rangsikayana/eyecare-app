package com.submission.eyecare.ui.fragments.meds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.eyecare.R
import com.submission.eyecare.adapter.DiseaseAdapter
import com.submission.eyecare.adapter.MedsAdapter
import com.submission.eyecare.data.local.Diseases
import com.submission.eyecare.data.local.Medications
import com.submission.eyecare.databinding.FragmentHomeBinding
import com.submission.eyecare.databinding.FragmentMedicationBinding
import java.util.Locale

class MedicationFragment : Fragment() {

    private var _binding: FragmentMedicationBinding? = null

    private val binding get() = _binding!!
    private var itemList =  ArrayList<Medications>()
    private lateinit var medsAdapter : MedsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicationBinding.inflate(inflater, container, false)
        val root = binding.root

        if (itemList.isEmpty()) {
            itemList.addAll(getData())
        }
        setup()

        //fix search view or remove this
        /*binding.searchMeds.setOnQueryTextListener(object : OnQueryTextListener
        {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                filterList(query)
                return true
            }

        })*/

        return root
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filtered = ArrayList<Medications>()
            for (i in itemList) {
                if (i.name.toLowerCase(Locale.ROOT).contains(query)){
                    filtered.add(i)
                }
            }
            if (filtered.isEmpty()) {
                Toast.makeText(requireActivity(), "None Found", Toast.LENGTH_SHORT).show()
            } else {
                medsAdapter.setFiltered(filtered)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setup() {
        val rv = binding.medsRv
        val adapter = MedsAdapter(itemList)
        rv.setHasFixedSize(true)
        rv.layoutManager = GridLayoutManager(requireActivity(), 2)
        rv.adapter = adapter
    }

    private fun getData(): ArrayList<Medications> {
        val dataMed = resources.getStringArray(R.array.data_medication)
        val dataOver = resources.getStringArray(R.array.data_overview)
        val dataAbout = resources.getStringArray(R.array.data_about)
        val dataUrl = resources.getStringArray(R.array.data_med_photo)
        val listMed = ArrayList<Medications>()
        for (i in dataMed.indices) {
            val item  = Medications(dataUrl[i], dataMed[i], dataOver[i], dataAbout[i])
            listMed.add(item)
        }
        return listMed
    }

}