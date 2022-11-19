package com.example.storyapp.data.model.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val name: String,
    val userId: String,
    val token: String,
    val isLogin: Boolean = false
): Parcelable
