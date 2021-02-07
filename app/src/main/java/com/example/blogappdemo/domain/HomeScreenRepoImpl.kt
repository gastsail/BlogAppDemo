package com.example.blogappdemo.domain

import com.example.blogappdemo.core.Resource
import com.example.blogappdemo.data.model.Post
import com.example.blogappdemo.data.remote.HomeScreenDataSource

class HomeScreenRepoImpl(private val dataSource: HomeScreenDataSource): HomeScreenRepo {

    override suspend fun getLatestPosts(): Resource<List<Post>> = dataSource.getLatestPosts()
}