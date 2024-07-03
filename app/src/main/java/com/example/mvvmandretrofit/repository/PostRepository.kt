package com.example.mvvmandretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmandretrofit.api.ApiService
import com.example.mvvmandretrofit.models.PostsModel

class PostRepository (private  val apiService: ApiService){

    private val postsLiveData  = MutableLiveData<PostsModel>()

    val posts: LiveData<PostsModel>
        get() = postsLiveData

    suspend fun getPost(){
        val result = apiService.getPost()
        if(result.body() != null){
            postsLiveData.postValue(result.body())
        }
    }

}