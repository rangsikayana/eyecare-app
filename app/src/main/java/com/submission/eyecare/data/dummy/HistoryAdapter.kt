package com.submission.eyecare.data.dummy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.submission.eyecare.data.IshiharaPlate
import com.submission.eyecare.databinding.ItemHoldersBinding
import com.submission.eyecare.databinding.ItemPlateBinding
import com.submission.test2colorblind.PlateListAdapter

class HistoryAdapter(private var data: ArrayList<HistoryData>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHoldersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = data.size

    inner class HistoryViewHolder(private val binding: ItemHoldersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: HistoryData) {
            binding.userProfile.setImageResource(data.img)
            binding.categoryHist.text = data.category
            binding.percentHist.text = data.percent

        }
    }


}