package com.example.medanospaper.data

import com.example.medanospaper.model.PostModel
import com.example.medanospaper.util.Constants.Companion.POST
import com.example.medanospaper.util.Constants.Companion.POST_BY_CATEGORY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiMedanosPaper {
    @GET(POST)
    suspend fun getPosts(): Response<List<PostModel>>

    @GET("${POST_BY_CATEGORY}")
    suspend fun getPostsByCategoryId(@Query(value = "categories")categories:Int): Response<List<PostModel>>
}