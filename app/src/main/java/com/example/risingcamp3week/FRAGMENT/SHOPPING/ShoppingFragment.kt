package com.example.risingcamp3week.FRAGMENT.SHOPPING

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.OnScrollListener
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.risingcamp3week.MAIN.MainActivity
import com.example.risingcamp3week.R
import org.w3c.dom.Text


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

        /* toolbar */
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        searchView.setQuery("Shop 검색",true)

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

//        /* 스크롤시 툴바 줄어들게 */
//        // listener 구성, searchView와 shoptext 는 gone, searchView2 는 visible
//        val searchView = view.findViewById<SearchView>(R.id.searchView)
//        val searchView2 = view.findViewById<SearchView>(R.id.searchView2)
//        val shoptext = view.findViewById<TextView>(R.id.shoptext)
//        searchView.setQuery("Shop 검색", true)
//        searchView2.setQuery("Shop 검색", true)
//
//        val onScrollListener = object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                if(dy > 5){
//                    searchView.visibility = View.GONE
//                    shoptext.visibility = View.INVISIBLE
//                    searchView2.visibility = View.VISIBLE
//                }
//            }
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if(rv_shopping.scrollY == 0){
//                    searchView.visibility = View.VISIBLE
//                    shoptext.visibility = View.VISIBLE
//                    searchView2.visibility = View.INVISIBLE
//                }
//            }
//        }
//        rv_shopping.addOnScrollListener(onScrollListener)
    }


}