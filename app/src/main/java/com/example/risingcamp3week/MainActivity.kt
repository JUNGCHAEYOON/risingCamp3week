package com.example.risingcamp3week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.risingcamp3week.FRAGMENT.*
import com.example.risingcamp3week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding         // 1.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   // 2.
        setContentView(binding.root)                            // 3.
    
        //프래그먼트 연결 리스너 바텀 네비게이션
        binding.bnvMain.setOnItemSelectedListener {
            item -> changeFragment(
                when(item.itemId){
                    R.id.item1 -> {
                        HomeFragment()
                    }
                    R.id.item2 ->{
                        SearchFragment()
                    }
                    R.id.item3 ->{
                        RealsFragment()
                    }
                    R.id.item4 ->{
                        ShoppingFragment()
                    }
                    else -> {
                        MyPageFragment()
                    }
                }
            )
            true
        }
        binding.bnvMain.selectedItemId = R.id.item1
    }
    
    //프래그먼트 바꿔주는 함수
    private fun changeFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fl_con,fragment).commit()
    }

}