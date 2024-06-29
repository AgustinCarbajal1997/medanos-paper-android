package com.example.medanospaper.model

data class PostModel(
    val id: Int = 0,
    val date: String = "",
    val title: PostTitle = PostTitle(""),
    val jetpack_featured_media_url: String = "",
    val yoast_head_json: PostDescription = PostDescription(""),
    val content: PostContent = PostContent("")
)

data class PostTitle(
    val rendered: String
)
data class PostDescription(
    val og_description: String
)
data class PostContent(
    val rendered: String
)

