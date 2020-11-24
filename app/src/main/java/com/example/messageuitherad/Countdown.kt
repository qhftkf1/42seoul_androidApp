package com.example.messageuitherad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_countdown.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class Countdown : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)
        countTask(tv_count, btn_start, btn_stop)
        btn_main.setOnClickListener {
            startActivity( Intent(this, MainActivity::class.java))
        }
    }
}
fun countTask(count: TextView, start: Button, stop: Button){
    val job = GlobalScope.launch (Dispatchers.Main, start = CoroutineStart.LAZY){
        for(i in 42 downTo 1){
            count.text = "Countdown $i ..."
            delay(1000)
        }
        count.text = "Done!"
    }
    start.setOnClickListener { job.start() }
    stop.setOnClickListener {
        count.text = "stop!"
        job.cancel() }
}