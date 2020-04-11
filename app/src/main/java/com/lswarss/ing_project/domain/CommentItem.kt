package com.lswarss.ing_project.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommentItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
) : Parcelable