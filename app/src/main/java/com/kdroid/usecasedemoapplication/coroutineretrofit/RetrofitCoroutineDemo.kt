package com.kdroid.usecasedemoapplication.coroutineretrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kdroid.usecasedemoapplication.databinding.ActivityRetrofitCoroutineDemoBinding

class RetrofitCoroutineDemo : AppCompatActivity() {
    val TAG = RetrofitCoroutineDemo::class.java.canonicalName
    lateinit var binding: ActivityRetrofitCoroutineDemoBinding
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() called")
        binding = ActivityRetrofitCoroutineDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        // init value of repo
        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        // init view model
        postViewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<PostModel>)
            Log.d(TAG, it.toString())
            binding.progressBar.visibility = View.GONE
            binding.recylerView.visibility = View.VISIBLE

        })
    }

    private fun initRecyclerView() {
        postAdapter = PostAdapter(this, ArrayList())
        binding.recylerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@RetrofitCoroutineDemo)
            adapter = postAdapter
           binding.recylerView.recycledViewPool.setMaxRecycledViews(0,12)
            binding.recylerView.setItemViewCacheSize(0)



        }
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}