package com.kau.ganzi.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kau.ganzi.databinding.ItemManualTextBinding

class ManualAdapter(
    private val texts: List<String>
) : RecyclerView.Adapter<ManualAdapter.ManualViewHolder>() {

    inner class ManualViewHolder(val binding: ItemManualTextBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManualViewHolder {
        val binding = ItemManualTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ManualViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ManualViewHolder, position: Int) {
        holder.binding.text = texts[position]
    }

    override fun getItemCount(): Int = texts.size
}