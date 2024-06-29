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
}