package com.lswarss.ing_project.adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lswarss.ing_project.R
import com.lswarss.ing_project.domain.CommentItem
import com.lswarss.ing_project.domain.PhotoItem
import com.lswarss.ing_project.domain.UserWithItem
import com.lswarss.ing_project.network.PostsApiStatus
import com.squareup.picasso.Picasso

/**
 * When there is [UserWithItem] data it displays in form of recyclerview, and if not it hides the [RecyclerView]
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<UserWithItem>?) {
    val adapter = recyclerView.adapter as PostsAdapter
    adapter.submitList(data)
}

/**
 *  When there is [CommentItem] data it displays in form of recyclerview, and if not it hides the [RecyclerView]
 */
@BindingAdapter("listData2")
fun bindRecyclerView2(recyclerView: RecyclerView, data: List<CommentItem>?) {
    val adapter = recyclerView.adapter as CommentsAdapter
    adapter.submitList(data)
}

@BindingAdapter("listPhotos")
fun bindRecyclerView3(recyclerView: RecyclerView, data: List<PhotoItem>?) {
    val adapter = recyclerView.adapter as PhotosAdapter
    adapter.submitList(data)
}


/**
 * This binding adapter displays [PostsApiStatus], corresponding to the state of request
 */
@BindingAdapter("postApiStatus")
fun bindStatus(statusImageView: ImageView, status: PostsApiStatus?) {
    when (status) {
        PostsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        PostsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        PostsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageURL")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Log.d("imgUri", imgUrl)
        Picasso.get()
            .load(imgUrl)
            .resize(150, 150)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image_black_24dp)
            .into(imgView)
    }
}
