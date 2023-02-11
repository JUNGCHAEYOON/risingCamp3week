package com.example.risingcamp3week.FRAGMENT.MYPAGE

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp3week.MAIN.NewFeedActivity
import com.example.risingcamp3week.R
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.component1
import com.google.firebase.storage.ktx.component2
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.*


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
        // 뉴피드 생성 버튼
        val newFeedButton = view.findViewById<ImageView>(R.id.add_btn_mypage)
        newFeedButton.setOnClickListener {
            val intent = Intent(getActivity(), NewFeedActivity::class.java)
            startActivity(intent)
        }

        /* rv_maypage_horizontal */
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

        /* rv_feed */
        val rv_feed = view.findViewById<RecyclerView>(R.id.rv_feed)
        val itemList2 = ArrayList<MyPageFeedItem>()
        
        // 아이템 추가
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/76/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/75/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/74/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/73/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/72/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/71/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/70/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/69/200"))
        itemList2.add(MyPageFeedItem("https://picsum.photos/id/68/200"))


        // 파이어베이스 스토리지 파일 목록 나열
        val storage = Firebase.storage
        val listRef = storage.reference.child("feed")
        listRef.listAll()
            .addOnSuccessListener { (items, prefixes) ->
                prefixes.forEach { prefix ->
                }
                items.forEach { item ->
                    Log.d("AAAAAAAAAAAACCCCCCCCCCCCCC",item.toString())
                }
            }
            .addOnFailureListener {
            }

        /*
        여기서 부터 안됨 ㅠㅠㅠ
        *
        *
        *
        *
         */
        // url 로 다운로드 왜안되냐 진짜 ㅠㅠ
        val storageRef = FirebaseStorage.getInstance().reference
        storageRef.child("gs://rising3-a973a.appspot.com/feed/android.graphics.drawable.BitmapDrawable%401e3cc67.png").downloadUrl.addOnSuccessListener {
            // Got the download URL for 'users/me/profile.png'
            Log.d("AAAAAAAAAAAABBBBBBBBBBB","성공")
            Log.d("AAAAAAAAAAAABBBBBBBBBBB",it.toString())
        }.addOnFailureListener {
            // Handle any errors
            Log.d("AAAAAAAAAAAABBBBBBBBBBB","실패")
        }



        //어댑터 연결
        val myPageFeedAdapter = MyPageFeedAdapter(itemList2)
        myPageFeedAdapter.notifyDataSetChanged()
        rv_feed.adapter = myPageFeedAdapter
        rv_feed.layoutManager = GridLayoutManager(getContext(), 3)
    }
}



