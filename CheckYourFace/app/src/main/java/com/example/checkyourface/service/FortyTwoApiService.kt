package com.example.checkyourface.service

import com.example.checkyourface.repos.FortyTwoRepo
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FortyTwoApiService {
    @Headers("Authorization: Bearer ecae9024a55c29be89af88f845a20e95b3b1b6ef9d4c9076fdcdebb0e39d5164")
    @GET("v2/users/{owner}")
    fun getRepos(@Path("owner") owner: String): retrofit2.Call<FortyTwoRepo>
}

// 인터셉터