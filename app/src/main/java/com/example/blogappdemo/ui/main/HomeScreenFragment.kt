package com.example.blogappdemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.blogappdemo.R
import com.example.blogappdemo.data.model.Post
import com.example.blogappdemo.databinding.FragmentHomeScreenBinding
import com.example.blogappdemo.ui.main.adapters.HomeScreenAdapter
import com.google.firebase.Timestamp

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeScreenBinding.bind(view)

        val postList = listOf(Post("https://process.filestackapi.com/cache=expiry:max/resize=width:320/mrFuqDcrT3mXeujn6eEN",
        "Gastón Saillén", Timestamp.now(), "https://pbs.twimg.com/media/EkSsEFkXgAIftCu.jpg"),
            Post("https://process.filestackapi.com/cache=expiry:max/resize=width:320/mrFuqDcrT3mXeujn6eEN",
                "Gastón Saillén", Timestamp.now(), "https://scontent.frcu4-1.fna.fbcdn.net/v/t1.0-9/106530758_2678893845657378_3966756094933271382_o.png?_nc_cat=106&ccb=2&_nc_sid=730e14&_nc_eui2=AeHHhv6peYglFW6ZEHGoe3k-qJzNmLWuJeSonM2Yta4l5LLDC7USNYkKJGqCj5sJzpQ&_nc_ohc=bqermoNw7W4AX-vAJSz&_nc_ht=scontent.frcu4-1.fna&oh=f126b256015b1e8d0fe5a699d81d4f41&oe=6042BBF7"))

        binding.rvHome.adapter = HomeScreenAdapter(postList)
    }
}