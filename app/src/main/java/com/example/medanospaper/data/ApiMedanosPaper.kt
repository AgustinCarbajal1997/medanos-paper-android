package com.example.medanospaper.data

import com.example.medanospaper.model.PostModel
import com.example.medanospaper.util.Constants.Companion.POST
import retrofit2.Response
import retrofit2.http.GET

interface ApiMedanosPaper {
    @GET(POST)
    suspend fun getPosts(): Response<List<PostModel>>
}