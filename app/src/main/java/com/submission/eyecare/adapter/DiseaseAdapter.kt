package com.submission.eyecare.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.submission.eyecare.data.local.Diseases
import com.submission.eyecare.databinding.DiseaseHolderBinding
import com.submission.eyecare.ui.InfoActivity

class DiseaseAdapter(private val list: ArrayList<Diseases>) :
    RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder>() {

    inner class DiseaseViewHolder(private val bind: DiseaseHolderBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun insert(item: Diseases) {
            val desc = item.desc
            val img = item.pic
            bind.apply {
                diseaseName.text = item.name
                Glide.with(itemView)
                    .load(img)
                    .into(icDisease)
                disBtn.setOnClickListener {
                    val intent = Intent(it.context, InfoActivity::class.java)
                    intent.putExtra(InfoActivity.EXTRA_DESC, desc)
                    intent.putExtra(InfoActivity.EXTRA_DISEASE, item.name)
                    intent.putExtra(InfoActivity.EXTRA_IMG, item.pic)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiseaseViewHolder {
        val bind = DiseaseHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiseaseViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DiseaseViewHolder, position: Int) {
        val item = list[position]
        holder.insert(item)

    }

    fun newList(new: ArrayList<Diseases>) {
        val next = DiffUtil.calculateDiff(DIFFCALLBACK(list, new))
        list.clear()
        next.dispatchUpdatesTo(this)
    }

    class DIFFCALLBACK(
        private val oldList: ArrayList<Diseases>,
        private val newList: ArrayList<Diseases>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldList[oldItem].name == newList[newItem].name
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}