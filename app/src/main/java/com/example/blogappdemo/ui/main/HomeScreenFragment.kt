package com.example.blogappdemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.blogappdemo.R
import com.example.blogappdemo.core.Resource
import com.example.blogappdemo.data.model.Post
import com.example.blogappdemo.data.remote.HomeScreenDataSource
import com.example.blogappdemo.databinding.FragmentHomeScreenBinding
import com.example.blogappdemo.domain.HomeScreenRepoImpl
import com.example.blogappdemo.presentation.main.HomeScreenViewModel
import com.example.blogappdemo.presentation.main.HomeScreenViewModelFactory
import com.example.blogappdemo.ui.main.adapters.HomeScreenAdapter
import com.google.firebase.Timestamp

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeScreenViewModel> { HomeScreenViewModelFactory(HomeScreenRepoImpl(
        HomeScreenDataSource()
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeScreenBinding.bind(view)

        viewModel.fetchLatestPosts().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvHome.adapter = HomeScreenAdapter(result.data)
                }

                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Hubo un error : ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

    }
}