package com.example.getdatafromgithubapi.service

import com.example.getdatafromgithubapi.model.GithubRepo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPIService{
    @GET("users/{owner}/repos")
    fun getRepos(@Path("owner") owner: String) : Single<List<GithubRepo>>
}