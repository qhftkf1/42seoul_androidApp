package com.example.getdatafromgithubapi.client

import com.example.getdatafromgithubapi.service.GithubAPIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GithubClient {
    companion object{
        private const val BASE_URL = "https://api.github.com"

        fun getAPI(): GithubAPIService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAPIService::class.java)
    }
}