package com.submission.eyecare.ui.colorBlindTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.eyecare.R
import com.submission.eyecare.databinding.FragmentPlateListBinding
import com.submission.eyecare.viewModels.VMFactory
import com.submission.test2colorblind.PlateDetailFragment
import com.submission.test2colorblind.PlateListAdapter

class PlateListFragment : Fragment() {

    private var _binding: FragmentPlateListBinding? = null
    private val binding get() = _binding!!
    private val plateViewModel: PlateViewModel by viewModels {
        VMFactory.getInstance(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlateListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = PlateListAdapter(emptyList()) { plate ->
            val fragment = PlateDetailFragment.newInstance(plate)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
        binding.recyclerView.adapter = adapter

        plateViewModel.plates.observe(viewLifecycleOwner) { plates ->
            adapter.updatePlates(plates)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
