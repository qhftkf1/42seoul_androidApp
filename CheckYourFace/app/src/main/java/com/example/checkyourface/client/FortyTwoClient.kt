package com.example.checkyourface.client

import com.example.checkyourface.service.FortyTwoApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class FortyTwoClient {
    companion object{
        private const val  BASE_URL = "https://api.intra.42.fr"
        var url : String = ""
        fun getAPI(): FortyTwoApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FortyTwoApiService::class.java)

    }
}