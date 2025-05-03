package com.shettyharshith33.utils

import android.content.Context
import android.content.SharedPreferences

class TeacherSessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("TeacherSession", Context.MODE_PRIVATE)

    fun saveTeacherSession(uid: String) {
        prefs.edit().putString("uid", uid).apply()
    }

    fun getTeacherSession(): String? {
        return prefs.getString("uid", null)
    }

    fun clearTeacherSession() {
        prefs.edit().remove("uid").apply()
    }
}
