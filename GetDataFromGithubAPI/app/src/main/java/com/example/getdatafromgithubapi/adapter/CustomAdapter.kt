package com.example.getdatafromgithubapi.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getdatafromgithubapi.R
import com.example.getdatafromgithubapi.model.DataVo

class CustomAdapter (private val context: Context, private val dataList: ArrayList<DataVo>): RecyclerView.Adapter<CustomAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val userName = itemView.findViewById<TextView>(R.id.name)
        private val userCreate = itemView.findViewById<TextView>(R.id.create)

        fun bind(dataVo: DataVo, context: Context){
            userName.text = dataVo.name
            userCreate.text = dataVo.create
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("bind-----------", "${dataList.size}")
        return dataList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

}