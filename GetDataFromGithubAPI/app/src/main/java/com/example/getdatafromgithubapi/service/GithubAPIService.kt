package com.example.getdatafromgithubapi.service

import com.example.getdatafromgithubapi.model.GithubRepo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface GithubAPIService{
    @GET("users/{owner}/repos")
    fun getRepos(@Path("owner") owner: String) : Single<List<GithubRepo>>
}

interface FortyTwoAPIService{
    @Headers("Authorization : Bearer 46d6a3e4b67e2a976150ada2bd789b09fa21c21bea44132a4407592ef428d50f" )
    @GET("v2/apps")
    fun getRepos(@Path("owner") owner: String) : Single<List<GithubRepo>>
}