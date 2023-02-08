package com.example.risingcamp3week.FRAGMENT.SHOPPING

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingcamp3week.R

class ShoppingAdapter (val itemList : ArrayList<ShoppingItem>) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
//        holder.item_shopping.setImageResource(itemList[position].image)
        Glide.with(holder.itemView.context).load(itemList[position].image).into(holder.item_shopping)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val item_shopping = itemView.findViewById<ImageView>(R.id.item_shopping)
    }
}