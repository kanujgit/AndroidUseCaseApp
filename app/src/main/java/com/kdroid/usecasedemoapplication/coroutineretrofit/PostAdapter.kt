package com.kdroid.usecasedemoapplication.coroutineretrofit

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kdroid.usecasedemoapplication.R

class PostAdapter(private val context: Context, private var postList: ArrayList<PostModel>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    val TAG: String = PostAdapter::class.simpleName.toString()
    var intCounterViewHolder: Int = 0


    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.text_title)
        val body: TextView = itemView.findViewById(R.id.text_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        Log.d(TAG, "onCreateViewHolderCalled ${++intCounterViewHolder}");
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    var binderCounter:Int =0;
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Log.d(TAG, "OnBindViewHolder called ${++binderCounter}");
        val post = postList[position]
        holder.body.text = post.body
        holder.titleTextView.text = post.title
    }

    var counterCount=0
    override fun getItemCount(): Int {
     //   Log.d(TAG, "getItemCountCalled ${++counterCount} and total item is: ${postList.size}");
        return postList.size
    }

    fun setData(postList: ArrayList<PostModel>) {
        Log.d(TAG, "set data called");
        this.postList = postList
       // notifyDataSetChanged()

    }
}