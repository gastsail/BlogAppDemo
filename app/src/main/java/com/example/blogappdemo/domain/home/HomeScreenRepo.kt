package com.example.blogappdemo.domain.home

import com.example.blogappdemo.core.Resource
import com.example.blogappdemo.data.model.Post

interface HomeScreenRepo {
    suspend fun getLatestPosts(): Resource<List<Post>>
}