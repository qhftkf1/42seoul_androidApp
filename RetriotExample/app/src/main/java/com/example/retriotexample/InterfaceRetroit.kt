package com.example.retriotexample

import android.text.format.DateFormat
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface CoronaAPIService{
    @GET("openapi/service/rest/Covid19/getCovid19InfStateJson")
    fun getAPI(
        @Query("serviceKey") serviceKey: String,
        @Query("pageNo") pageNo : String,
        @Query("numOfRows") numOfRows : String,
        @Query("startCreateDt") start : String,
        @Query("endCreateDt") end : String
    ): Call<Response>
    companion object{
        val BASE_URL = "http://openapi.data.go.kr/"
        fun create(): CoronaAPIService{
            val client = OkHttpClient.Builder()
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
//                .callFactory(OkHttpClient.Builder().build())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(CoronaAPIService::class.java)
        }
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .callFactory(OkHttpClient.Builder().build())
//            .addConverterFactory(JaxbConverterFactory.create())
//            .build()
//
//        val api = retrofit.create(CoronaAPIService::class.java)
//        val callCoronaAPI = api.getAPI(CLIENT_KEY, null, null, null, null)
    }

}

