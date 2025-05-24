package com.kau.ganzi.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kau.ganzi.databinding.ItemMainButtonBinding

class MainAdapter(
    private val texts: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(val binding: ItemMainButtonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainButtonBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val text = texts[position]
        holder.binding.buttonText = text

        holder.binding.buttonItem.setOnClickListener {
            onClick(text)
        }
    }

    override fun getItemCount() = texts.size
}

