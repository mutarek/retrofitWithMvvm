package com.example.mvvmandretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandretrofit.R
import com.example.mvvmandretrofit.models.PostsModel

class PostAdapter(var postList: PostsModel) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val  tvTitle = itemView.findViewById<TextView>(R.id.sampleTitileID)
        val tvBody = itemView.findViewById<TextView>(R.id.sampleBodyID)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sample_layout, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        holder.tvTitle.text = postList[position].title
        holder.tvBody.text = postList[position].body
    }

    override fun getItemCount(): Int {
        return  postList.size
    }
}