package com.example.mvvmandretrofit.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmandretrofit.ViewModel.MainViewModel
import com.example.mvvmandretrofit.repository.PostRepository

class MainViewModelFactory constructor(private  val repository: PostRepository) :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}

class  PostView