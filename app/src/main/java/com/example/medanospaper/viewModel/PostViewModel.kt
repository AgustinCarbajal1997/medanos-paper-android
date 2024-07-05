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
    private val _selectedPost = MutableStateFlow<PostModel>(PostModel())
    private val _postsByCategory = MutableStateFlow<List<PostModel>>(emptyList())
    private val _loading = MutableStateFlow<Boolean>(false)
    private val _loadingByCategory = MutableStateFlow<Boolean>(false)
    val posts = _posts.asStateFlow()
    val selectedPost = _selectedPost.asStateFlow()
    val postsByCategory = _postsByCategory.asStateFlow()
    val loading = _loading.asStateFlow()
    val loadingByCategory = _loadingByCategory.asStateFlow()

    init {
        fetchPosts()
    }

    private fun fetchPosts(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _loading.value = true
                val result = repo.getPosts()
                println(result)
                _posts.value = result ?: emptyList()
                _loading.value = false
            }
        }
    }

    fun fetchPostsByCategoryId(categories: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _loadingByCategory.value = true
                val result = repo.getPostsByCategory(categories)
                println("result agro" + " " + result)
                _postsByCategory.value = result ?: emptyList()
                _loadingByCategory.value = false
            }
        }
    }

    fun onSelectPost(post: PostModel){
        _selectedPost.value = post
    }

    fun onCleanSelectPost(){
        _selectedPost.value = PostModel()
    }

    fun onCleanPostsByCategory(){
        _postsByCategory.value = emptyList()
    }
}