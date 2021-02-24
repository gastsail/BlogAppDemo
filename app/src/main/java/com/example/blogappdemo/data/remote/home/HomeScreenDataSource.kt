package com.example.blogappdemo.data.remote.home

import com.example.blogappdemo.core.Resource
import com.example.blogappdemo.data.model.Post
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {

    suspend fun getLatestPosts(): Resource<List<Post>> {
        val postList = mutableListOf<Post>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("posts").get().await()
        for(post in querySnapshot.documents){
            post.toObject(Post::class.java)?.let { postList.add(it) }
        }
        return Resource.Success(postList)
    }
}