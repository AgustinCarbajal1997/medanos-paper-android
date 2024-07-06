package com.example.medanospaper.repository

import com.example.medanospaper.data.ApiMedanosPaper
import com.example.medanospaper.model.PostModel
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiMedanosPaper: ApiMedanosPaper){
    suspend fun getPosts(): List<PostModel> ? {
        val response = apiMedanosPaper.getPosts()
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }

    suspend fun loadMorePosts(perPage: Int, before: String): List<PostModel> ? {
        val response = apiMedanosPaper.loadMorePosts(perPage, before)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }

    suspend fun getPostsByCategory(categories: Int): List<PostModel> ? {
        val response = apiMedanosPaper.getPostsByCategoryId(categories)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }
}