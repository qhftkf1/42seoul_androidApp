package com.example.retriotexample

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.net.URLDecoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


val CLIENT_KEY = "EzoCrM4K%2BvEBJjeY9FGY7Mi7uqk%2FMHP3NOmqDgRJzPAWMxQ3jzznKIXQmIN6bbGEQXCPoWNqnQ6ZiQ7RFwCbSw%3D%3D"



class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)

    fun getCoronaApi(){
        // 시간을 현재로 맞춰 (어제 총 확진자 수 - 오늘 총 확진자 수)
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        val formatted = current.format(formatter).toString()
        //
        val testapi = CoronaAPIService.create()
        testapi.getAPI( URLDecoder.decode(CLIENT_KEY, "UTF-8"),"1", "10", "20200315", formatted).enqueue(object : Callback<com.example.retriotexample.Response>{
            override fun onFailure(call: Call<com.example.retriotexample.Response>, t: Throwable) {
                Log.d("결과:", "실패 : ${t.message}, ${t.printStackTrace()}")
            }
            override fun onResponse(call: Call<com.example.retriotexample.Response>, response: Response<com.example.retriotexample.Response>) {
                var data  = response.body()?.body?.items?.item
                var todayCorona = data?.get(0)
                var yesterdayCorona = data?.get(1)
                coronaTodayContent.setText((Integer.parseInt(todayCorona?.decideCnt) - Integer.parseInt(yesterdayCorona?.decideCnt)).toString())
                coronaTodayDeathContent.setText((Integer.parseInt(todayCorona?.deathCnt) - Integer.parseInt(yesterdayCorona?.deathCnt)).toString())
                coronaTodayCareContent.setText((Integer.parseInt(todayCorona?.careCnt) - Integer.parseInt(yesterdayCorona?.careCnt)).toString())
                coronaTodayExamContent.setText((Integer.parseInt(todayCorona?.examCnt) - Integer.parseInt(yesterdayCorona?.examCnt)).toString())
            }
        })
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coronaButton.setOnClickListener { getCoronaApi()}

    }

}