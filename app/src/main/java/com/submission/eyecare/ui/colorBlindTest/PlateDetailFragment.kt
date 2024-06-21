package com.submission.test2colorblind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.submission.eyecare.data.local.IshiharaPlate
import com.submission.eyecare.databinding.FragmentPlateDetailBinding

class PlateDetailFragment : Fragment() {

    private var _binding: FragmentPlateDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var plate: IshiharaPlate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            plate = it.getParcelable(ARG_PLATE)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlateDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.plateImage.setImageResource(plate.imageResId)
        binding.submitButton.setOnClickListener {
            val userAnswer = binding.answerEditText.text.toString()
            if (userAnswer.isNotBlank()) {
                binding.answerEditText.isEnabled = false
                binding.correctAnswerText.visibility = View.VISIBLE
                binding.correctAnswerText.text = "${plate.correctAnswer}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_PLATE = "plate"

        fun newInstance(plate: IshiharaPlate) =
            PlateDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PLATE, plate)
                }
            }
    }
}
