package com.submission.eyecare.data.dummy

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.submission.eyecare.databinding.ItemHoldersBinding
import java.io.File

class HistoryAdapter(
    private var data: ArrayList<HistoryData>,
    private val onDeleteClick: (HistoryData) -> Unit // Add a callback for delete
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    var onItemClick: ((HistoryData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHoldersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyData = data[position]
        holder.bind(historyData)
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: ArrayList<HistoryData>) {
        data = newData
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: ItemHoldersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(historyData: HistoryData) {
            val imageFile = File(historyData.img)
            if (imageFile.exists()) {
                Glide.with(binding.userProfile.context)
                    .load(imageFile)
                    .into(binding.userProfile)
            } else {
                Glide.with(binding.userProfile.context)
                    .load(Uri.parse(historyData.img))
                    .into(binding.userProfile)
            }
            binding.categoryHist.text = historyData.category
            binding.percentHist.text = historyData.percent

            itemView.setOnClickListener {
                onItemClick?.invoke(historyData)
            }

            // Set up delete button click listener
            binding.btnDel.setOnClickListener {
                onDeleteClick(historyData)
            }
        }
    }
}
