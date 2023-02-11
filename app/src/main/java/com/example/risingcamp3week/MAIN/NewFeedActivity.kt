package com.example.risingcamp3week.MAIN

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import com.example.risingcamp3week.FIREBASE.FirebaseAuthUtils
import com.example.risingcamp3week.R
import com.example.risingcamp3week.databinding.ActivityMainBinding
import com.example.risingcamp3week.databinding.ActivityNewFeedBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream

class NewFeedActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* toolbar */
        // 뒤로가기 화살표 버튼
        val backButton : ImageView = findViewById(R.id.arrowback)
        backButton.setOnClickListener {
            // 작성중이던 내용이 저장되는 기능 추가!
            // onDestroy
            finish()
        }

        // 글쓰기 파란색 체크 버튼
        val newFeedButton : ImageView = findViewById(R.id.newfeed_btn)
        newFeedButton.setOnClickListener {
            // 데이터 전달
            // 파이어베이스 이용해 drawable 을 realtimedatabase로!
            val buff : Drawable = binding.newfeedImageButton.drawable
            val buffstr : String = binding.newfeedImageButton.drawable.toString()
            saveImg(buff, buffstr)
            // onDestroy
            finish()
        }

        /* new feed button 이미지 불러오기 */
        val getAction = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback { uri ->
                binding.newfeedImageButton.setImageURI(uri)
            }
        )
        binding.newfeedImageButton.setOnClickListener {
            getAction.launch("image/*")
        }
    }

    private fun saveImg(drawable: Drawable, str : String){
        // todo : drawable 을 firebase storage로 저장!
        val storage = Firebase.storage
        val storageRef = storage.reference.child("feed/" + str + ".png")

        /* 파이어베이스 제공 코드 */
        val bitmap = (drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = storageRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
            Toast.makeText(this, "저장 실패!", Toast.LENGTH_SHORT).show()
        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
            Toast.makeText(this, "저장 완료!", Toast.LENGTH_SHORT).show()
        }

    }
}