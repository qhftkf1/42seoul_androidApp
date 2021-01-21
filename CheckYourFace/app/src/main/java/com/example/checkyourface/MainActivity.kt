package com.example.checkyourface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import com.bumptech.glide.Glide
import com.example.checkyourface.client.FortyTwoClient
import com.example.checkyourface.databinding.ActivityMainBinding
import com.example.checkyourface.repos.FortyTwoRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.Result.Companion.success

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var userId : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.title42.text = "Find you 42"
        binding.search42.setOnQueryTextListener(object : SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if(p0 != null){
                    userId = p0
                };
                fortyTwoImg(userId)

                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        Log.d("fffffffff", "${FortyTwoClient.url}")

        Glide.with(this).load(FortyTwoClient.url).into(binding.fwImg)
        setContentView(binding.root)
    }

    fun fortyTwoImg(userId: String){
        FortyTwoClient.getAPI().getRepos(userId)
            .enqueue(object : Callback<FortyTwoRepo> {
                override fun onResponse(
                    call: Call<FortyTwoRepo>,
                    response: Response<FortyTwoRepo>
                ) {
                    Log.d("eeeeeeee", "${userId}")
                    FortyTwoClient.url = response.body()?.url.toString()
                    Log.d("url", "${FortyTwoClient.url}")
                    Glide.with(this@MainActivity).load(FortyTwoClient.url).into(binding.fwImg)
                    if(response.isSuccessful)
                        success(response.body())
                }
                override fun onFailure(call: Call<FortyTwoRepo>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }
}
