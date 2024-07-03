package com.example.mvvmandretrofit.api

import com.example.mvvmandretrofit.models.PostsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPost() :Response<PostsModel>
}