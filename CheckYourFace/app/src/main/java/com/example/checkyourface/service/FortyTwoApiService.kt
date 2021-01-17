package com.example.checkyourface.service

import com.example.checkyourface.repos.FortyTwoRepo
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FortyTwoApiService {
    @Headers("Authorization: Bearer 7584fbc492f302443cfc48e2bffd47a71403abba61662e5b42334bac69e2ec60")
    @GET("v2/users/{owner}")
    fun getRepos(@Path("owner") owner: String): retrofit2.Call<FortyTwoRepo>
}