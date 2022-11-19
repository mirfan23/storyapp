package com.example.storyapp.data.preferences

import android.content.Context
import com.example.storyapp.data.model.local.UserData

class UserPreferences(context: Context) {
    companion object {
        private const val PREF_NAME = "user_pref"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_NAME = "name"
        private const val KEY_TOKEN = "token"
        private const val KEY_LOG_STATUS = "log_status"

    }

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor = pref.edit()

    fun setUser(data: UserData) {
        editor.apply {
            putString(KEY_USER_ID, data.userId)
            putString(KEY_NAME, data.name)
            putString(KEY_TOKEN, data.token)
            putBoolean(KEY_LOG_STATUS, data.isLogin)
            apply()
        }
    }

    fun getUser(): UserData =
        UserData(
            pref.getString(KEY_USER_ID, "").toString(),
            pref.getString(KEY_NAME, "").toString(),
            pref.getString(KEY_TOKEN, "").toString(),
            pref.getBoolean(KEY_LOG_STATUS, false)
        )

    fun logout() {
        editor.apply {
            remove(KEY_USER_ID)
            remove(KEY_NAME)
            remove(KEY_TOKEN)
            putBoolean(KEY_LOG_STATUS, false)
            apply()
        }
    }


}