package com.example.mvvmandretrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmandretrofit.models.PostsModel
import com.example.mvvmandretrofit.repository.PostRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel (private val repository: PostRepository) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getPost()
        }
    }

    val posts : LiveData<PostsModel> get() = repository.posts
    val isLoading : LiveData<Boolean> get() = repository.loadingState
}