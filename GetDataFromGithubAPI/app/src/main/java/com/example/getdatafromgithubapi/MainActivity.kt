package com.example.getdatafromgithubapi

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getdatafromgithubapi.adapter.CustomAdapter
import com.example.getdatafromgithubapi.client.GithubClient
import com.example.getdatafromgithubapi.databinding.ActivityMainBinding
import com.example.getdatafromgithubapi.model.DataVo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    var userList = arrayListOf<DataVo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        GithubClient.getAPI().getRepos("qhftkf1")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({items ->
                items.forEach{
                    Log.d("it----------------","${it.name}, ${it.date}")
                    userList.add( DataVo(it.name, it.date))
                }
                val mAdapter = CustomAdapter(this, userList)
                binding.recyclerView.adapter = mAdapter

//                val layout = LinearLayoutManager(this)
//                binding.recyclerView.layoutManager = layout
//                binding.recyclerView.setHasFixedSize(true)
            }, { e ->
                println(e.toString())
            })

        setContentView(binding.root)

//        GithubClient.getAPI().getRepos("qhftkf1")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({items ->
//                items.forEach{ println(it)}
//            }, { e ->
//                println(e.toString())
//            })
    }
}