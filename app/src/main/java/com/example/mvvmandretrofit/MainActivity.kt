package com.example.mvvmandretrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmandretrofit.ViewModel.MainViewModel
import com.example.mvvmandretrofit.adapter.PostAdapter
import com.example.mvvmandretrofit.api.ApiService
import com.example.mvvmandretrofit.api.RetrofitHelper
import com.example.mvvmandretrofit.factory.MainViewModelFactory
import com.example.mvvmandretrofit.repository.PostRepository

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private lateinit var postAdapter: PostAdapter
    private lateinit var progress : ProgressBar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress = findViewById<ProgressBar>(R.id.progressBar)
        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repo = PostRepository(apiService)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repo)).get(MainViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recyllerview)

        mainViewModel.posts.observe(this, Observer {
            postAdapter = PostAdapter(it)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = postAdapter
        })

        mainViewModel.isLoading.observe(this, Observer {
            if (it) {
                progress.visibility = View.VISIBLE
            } else {
                progress.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }
        })
    }
}