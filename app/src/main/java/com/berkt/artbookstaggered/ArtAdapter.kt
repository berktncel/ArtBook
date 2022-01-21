package com.berkt.artbookstaggered

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berkt.artbookstaggered.databinding.ArtItemBinding

class ArtAdapter(val artList: ArrayList<Art>): RecyclerView.Adapter<ArtAdapter.ArtHolder>() {

    class ArtHolder(val binding: ArtItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding = ArtItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.binding.tvArt.text = artList[position].artName
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ArtActivity::class.java)
            intent.putExtra("info", "old")
            intent.putExtra("id", artList[position].id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = artList.size
}