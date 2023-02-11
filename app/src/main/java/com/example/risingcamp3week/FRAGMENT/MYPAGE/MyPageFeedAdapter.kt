package com.example.risingcamp3week.FRAGMENT.MYPAGE

import android.app.PendingIntent.getActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingcamp3week.MAIN.MainActivity
import com.example.risingcamp3week.R
import java.security.AccessController.getContext

class MyPageFeedAdapter(val itemList : ArrayList<MyPageFeedItem>) : RecyclerView.Adapter<MyPageFeedAdapter.MyPageFeedViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageFeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mypagefeed,parent,false)
        return MyPageFeedViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyPageFeedViewHolder, position: Int) {
//        // 이미지 클릭시 리스너
//        holder.feed_image.setOnClickListener {
//            //todo
//        }
//        holder.feed_image.setImageDrawable(itemList[position].image)
        Glide.with(holder.feed_image.context).load(itemList[position].image).into(holder.feed_image)
    }
    override fun getItemCount(): Int {
        return itemList.count()
    }
    inner class MyPageFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val feed_image = itemView.findViewById<ImageView>(R.id.item_feed)
    }
}