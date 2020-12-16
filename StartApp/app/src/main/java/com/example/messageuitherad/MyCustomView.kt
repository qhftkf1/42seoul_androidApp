package com.example.messageuitherad

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_custom_view.*

class MyCustomView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val v = MyView(this)
        setContentView(R.layout.activity_my_custom_view)
        ChangeColor.setOnClickListener {
            myView.setBackgroundColor(Color.BLACK)
        }
//        setContentView(v)
    }
}