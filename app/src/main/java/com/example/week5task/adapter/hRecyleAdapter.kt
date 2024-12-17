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
    val subjectList:Array<String>,
    val dateList:Array<String>,
    val statusList:Array<String>
):RecyclerView.Adapter<hRecyleAdapter.hRecyleViewHolder>() {
    class hRecyleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tvSubjectName)
        var date: TextView = itemView.findViewById(R.id.tvDate)
        var status: TextView = itemView.findViewById(R.id.tvPresentAbsentLabel)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): hRecyleAdapter.hRecyleViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.story_icon,parent,false)
        return hRecyleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: hRecyleAdapter.hRecyleViewHolder, position: Int) {
        holder.title.text = subjectList[position]
        holder.date.text = dateList[position]
        holder.status.text = statusList[position]
//        holder.image.setImageResource(imageList[position])
//        holder.title.text = titleList[position]

    }

    override fun getItemCount(): Int {
        return subjectList.size;
    }

}