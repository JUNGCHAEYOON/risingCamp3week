package com.example.risingcamp3week.FRAGMENT.SHOPPING

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp3week.R


class ShoppingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* rv */
        val rv_shopping = view.findViewById<RecyclerView>(R.id.rv_shopping)
        val itemList = ArrayList<ShoppingItem>()
        // item 추가
        itemList.add(ShoppingItem("https://picsum.photos/id/1/200"))
        itemList.add(ShoppingItem("https://picsum.photos/id/21/200"))
        itemList.add(ShoppingItem("https://picsum.photos/id/30/200"))
        itemList.add(ShoppingItem("https://picsum.photos/id/48/200"))
        itemList.add(ShoppingItem("https://picsum.photos/id/63/200"))
        itemList.add(ShoppingItem("https://picsum.photos/id/76/200"))


        // 어댑터 연결
        val shoppingAdapter = ShoppingAdapter(itemList)
        shoppingAdapter.notifyDataSetChanged()
        rv_shopping.adapter = shoppingAdapter
        rv_shopping.layoutManager = GridLayoutManager(getContext(), 2)

        // rv 정사각형 spacing

    }
}