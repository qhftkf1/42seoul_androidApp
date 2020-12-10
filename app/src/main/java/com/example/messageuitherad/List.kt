package com.example.messageuitherad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.List

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        section_1.setOnClickListener {
            startActivity( Intent(this, Countdown::class.java))
        }
        section_2.setOnClickListener {
            startActivity( Intent(this, MyCustomView::class.java))
        }
    }
}