package com.hfad.firstkotlinapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hfad.firstkotlinapp.R
import com.hfad.firstkotlinapp.dataClasses.Achievement

class AchievementsAdapter (private val achievementsList: ArrayList<Achievement>) : RecyclerView.Adapter<AchievementsAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = achievementsList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = achievementsList[position]
        holder.captionImg.setImageResource(currentItem.captionImg)
        holder.achievementTitle.text = currentItem.achievementTitle
        holder.achievementDate.text = currentItem.achievementDate
    }

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val captionImg: ShapeableImageView = itemView.findViewById(R.id.shapeableImgView_listItemBlueprint)
        val achievementTitle: TextView = itemView.findViewById(R.id.textView1_listItemBlueprint)
        val achievementDate: TextView = itemView.findViewById(R.id.textView2_listItemBlueprint)
    }

}