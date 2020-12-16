package com.example.retriotexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


val CLIENT_KEY = "EzoCrM4K%2BvEBJjeY9FGY7Mi7uqk%2FMHP3NOmqDgRJzPAWMxQ3jzznKIXQmIN6bbGEQXCPoWNqnQ6ZiQ7RFwCbSw%3D%3D"


class MainActivity : AppCompatActivity() {

    /**
     * Our MainActivity is only responsible for setting the content view that contains the
     * Navigation Host.
     */
//    private fun getCoronaProperites(){
//        callCoronaAPI.enqueue(object : Callback<XmlResponse> {
//            override fun onFailure(call: Call<XmlResponse>, t: Throwable) {
//                Log.d("결과:", "실패 : $t")
//            }
//
//            override fun onResponse(call: Call<XmlResponse>, response: Response<XmlResponse>) {
//                Log.d("결과:", "성공 : ${response.raw()}")
//            }
//        })
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        getCoronaProperites()
        val testapi = CoronaAPIService.create()
        testapi.getAPI(CLIENT_KEY,  "1", "10", "20200310", "20200315").enqueue(object : Callback<com.example.retriotexample.Response>{
            override fun onFailure(call: Call<com.example.retriotexample.Response>, t: Throwable) {
                Log.d("결과:", "실패 : $t")
            }

            override fun onResponse(call: Call<com.example.retriotexample.Response>, response: Response<com.example.retriotexample.Response>) {
                Log.d("결과:", "성공 : ${response.raw()}")
            }
        })
    }

}