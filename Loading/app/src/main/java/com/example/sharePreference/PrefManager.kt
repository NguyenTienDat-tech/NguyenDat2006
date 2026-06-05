package com.example.sharePreference

import android.content.Context
import androidx.core.content.edit

class PrefManager(context: Context) {

    companion object {
        private const val PREF_NAME = "APP_PREF"
        private const val KEY = "seen_APP"
    }

    private val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setOnPref(check: Boolean) {
        prefs.edit { putBoolean(KEY, check) }
    }

    fun isOnPref(): Boolean {
        return prefs.getBoolean(KEY, false)
    }
}