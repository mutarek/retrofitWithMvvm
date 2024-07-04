package com.example.mvvmandretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmandretrofit.api.ApiService
import com.example.mvvmandretrofit.models.PostsModel

class PostRepository (private  val apiService: ApiService){

    private val loading = MutableLiveData<Boolean>()
    private val postsLiveData  = MutableLiveData<PostsModel>()

    val posts: LiveData<PostsModel>
        get() = postsLiveData
    val loadingState: LiveData<Boolean>
        get() = loading

    suspend fun getPost(){
        val result = apiService.getPost()
        if(result.body() != null){
            loading.postValue(false)
            postsLiveData.postValue(result.body())
        }
    }

}