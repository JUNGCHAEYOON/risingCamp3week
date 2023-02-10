package com.example.risingcamp3week.FRAGMENT.MYPAGE

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp3week.R

class MyPageHorizontalAdapter (val itemList : ArrayList<MyPageHorizontalItem>) : RecyclerView.Adapter<MyPageHorizontalAdapter.MyPageHorizontalViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageHorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mypagehorizontal_item,parent,false)
        return MyPageHorizontalViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyPageHorizontalViewHolder, position: Int) {
        holder.profile_image.setImageResource(itemList[position].image)
        holder.profile_name.text = itemList[position].name
        holder.profile_info.text = itemList[position].info
    }
    override fun getItemCount(): Int {
        return itemList.count()
    }
    inner class MyPageHorizontalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val profile_image = itemView.findViewById<ImageView>(R.id.profile_image)
        val profile_name = itemView.findViewById<TextView>(R.id.profile_name)
        val profile_info = itemView.findViewById<TextView>(R.id.profile_info)
    }
}