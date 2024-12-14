package com.example.week5task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week5task.R

class hRecyleAdapter(
    val context: Context,
    val imageList:Array<Int>,
    val titleList:Array<String>
):RecyclerView.Adapter<hRecyleAdapter.hRecyleViewHolder>() {
    class hRecyleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.imageVw1)
        var title: TextView = itemView.findViewById(R.id.titleVw)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): hRecyleAdapter.hRecyleViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.story_icon,parent,false)
        return hRecyleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: hRecyleAdapter.hRecyleViewHolder, position: Int) {
        holder.image.setImageResource(imageList[position])
        holder.title.text = titleList[position]

    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}