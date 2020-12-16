package com.example.retriotexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.net.URLDecoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


val CLIENT_KEY = "EzoCrM4K%2BvEBJjeY9FGY7Mi7uqk%2FMHP3NOmqDgRJzPAWMxQ3jzznKIXQmIN6bbGEQXCPoWNqnQ6ZiQ7RFwCbSw%3D%3D"


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        val formatted = current.format(formatter).toString()
        val testapi = CoronaAPIService.create()
        Log.d("시간","${formatted}")
        testapi.getAPI( URLDecoder.decode(CLIENT_KEY, "UTF-8"),"1", "10", "20201215", formatted).enqueue(object : Callback<com.example.retriotexample.Response>{
            override fun onFailure(call: Call<com.example.retriotexample.Response>, t: Throwable) {
                Log.d("결과:", "실패 : ${t.message}, ${t.printStackTrace()}")
            }
            override fun onResponse(call: Call<com.example.retriotexample.Response>, response: Response<com.example.retriotexample.Response>) {
                Log.d("결과:", "성공 : ${response.body()?.body?.items?.item?.get(1)}")
                var data  = response.body()?.body?.items?.item
                Log.d("결과2","${data?.toString()}")
                var yesterdayDecide: Int = Integer.parseInt(data?.get(0)?.decideCnt)
                var todayDecide: Int = Integer.parseInt(data?.get(1)?.decideCnt)
//                coronaTodayContent.setText((yesterdayDecide - todayDecide).toString())
            }
        })
    }

}
