package com.example.medanospaper.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medanospaper.model.PostContent
import com.example.medanospaper.model.PostDescription
import com.example.medanospaper.model.PostModel
import com.example.medanospaper.model.PostTitle
import com.example.medanospaper.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repo: PostRepository): ViewModel(){
    private val _posts = MutableStateFlow<List<PostModel>>(emptyList())
    val posts = _posts.asStateFlow()
    private val _selectedPost = MutableStateFlow<PostModel>(PostModel())
    val selectedPost = _selectedPost.asStateFlow()
    init {
        fetchPosts()
    }

    private fun fetchPosts(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getPosts()
                println(result)
                _posts.value = result ?: emptyList()
            }
        }
    }

    fun onSelectPost(post: PostModel){
        _selectedPost.value = post
    }

    fun onCleanSelectPost(){
        _selectedPost.value = PostModel()
    }
}