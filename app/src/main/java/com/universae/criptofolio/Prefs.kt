package com.universae.criptofolio

import android.content.Context

class Prefs(val context: Context) {

    val SHARED_NAME = "mis_preferencias"
    val SHARED_API = "api_key"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveApiKey(apiKey: String)
    {
        storage.edit().putString(SHARED_API, apiKey).apply()
    }

    fun getApiKey(): String{
        return storage.getString(SHARED_API, "")!!
    }
}