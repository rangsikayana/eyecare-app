package com.submission.test2colorblind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.submission.eyecare.data.IshiharaPlate
import com.submission.eyecare.databinding.ItemPlateBinding


class PlateListAdapter(
    private var plates: List<IshiharaPlate>,
    private val onPlateClick: (IshiharaPlate) -> Unit
) : RecyclerView.Adapter<PlateListAdapter.PlateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val binding = ItemPlateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        val plate = plates[position]
        holder.bind(plate)
    }

    override fun getItemCount(): Int = plates.size

    inner class PlateViewHolder(private val binding: ItemPlateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plate: IshiharaPlate) {
            binding.plateImage.setImageResource(plate.imageResId)
            binding.root.setOnClickListener { onPlateClick(plate) }
        }
    }

    fun updatePlates(newPlates: List<IshiharaPlate>) {
        plates = newPlates
        notifyDataSetChanged()
    }
}
