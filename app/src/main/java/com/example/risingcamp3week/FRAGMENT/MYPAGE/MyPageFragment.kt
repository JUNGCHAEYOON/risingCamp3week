package com.example.risingcamp3week.FRAGMENT.MYPAGE

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp3week.R

class MyPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* toolbar */
        //튕김
//        val toolbarMyPage = view.findViewById<Toolbar>(R.id.toolbar_mypage)

        /* rv */
        val rv_mypage_horizontal = view.findViewById<RecyclerView>(R.id.rv_mypage_horizontal)
        val itemList = ArrayList<MyPageHorizontalItem>()

        // item 추가
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"김철수","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"김정수","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"김철중","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"나철수","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"박정수","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"최철중","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"이철수","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"정정수","회원님을 팔로우 합니다."))
        itemList.add(MyPageHorizontalItem(R.drawable.ic_mypage,"철철중","회원님을 팔로우 합니다."))

        // 어댑터 연결
        val myPageHorizontalAdapter = MyPageHorizontalAdapter(itemList)
        myPageHorizontalAdapter.notifyDataSetChanged()
        rv_mypage_horizontal.adapter = myPageHorizontalAdapter
        rv_mypage_horizontal.layoutManager = LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false)
    }
}