package com.example.getdatafromgithubapi

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getdatafromgithubapi.adapter.CustomAdapter
import com.example.getdatafromgithubapi.client.GithubClient
import com.example.getdatafromgithubapi.databinding.ActivityMainBinding
import com.example.getdatafromgithubapi.model.DataVo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var userId : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.name.text = "Get Github repo"
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0 != null) {
                    userId = p0
                };
                githubData(userId)
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        setContentView(binding.root)
    }

    fun githubData(userId: String){
        GithubClient.getAPI().getRepos(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({items ->
                    var userList = arrayListOf<DataVo>()
                    items.forEach{
                        userList.add( DataVo(it.name, it.date))
                    }
                    val mAdapter = CustomAdapter(this, userList)
                    binding.recyclerView.adapter = mAdapter
                }, { e ->
                    println(e.toString())
                })
    }


}
