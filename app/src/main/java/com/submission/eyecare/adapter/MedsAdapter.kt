package com.submission.eyecare.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.submission.eyecare.data.local.Medications
import com.submission.eyecare.databinding.MedicationHolderBinding
import com.submission.eyecare.ui.InfoActivity
import com.submission.eyecare.ui.MedsActivity

class MedsAdapter (var list: ArrayList<Medications>): RecyclerView.Adapter<MedsAdapter.MedsViewHolder>() {
    inner class MedsViewHolder(private val bind: MedicationHolderBinding): RecyclerView.ViewHolder(bind.root) {
        fun insert(item: Medications) {
            val overview = item.overview
            val about = item.about
            val url = item.url
            bind.medsName.text = item.name
            Glide.with(itemView)
                .load(url)
                .into(bind.icMeds)
            bind.medsBtn.setOnClickListener{
                val intent = Intent(it.context, MedsActivity::class.java)
                intent.putExtra(MedsActivity.EXTRA_NAME, item.name)
                intent.putExtra(MedsActivity.EXTRA_OVERVIEW, overview)
                intent.putExtra(MedsActivity.EXTRA_ABOUT, about)
                intent.putExtra(MedsActivity.EXTRA_URL, url)
                itemView.context.startActivity(intent)
            }
        }
    }
    fun setFiltered(list: ArrayList<Medications>) {
        this.list = list
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedsViewHolder {
        val bind = MedicationHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedsViewHolder(bind)
    }

    override fun onBindViewHolder(holder: MedsAdapter.MedsViewHolder, position: Int) {
        val item = list[position]
        holder.insert(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}