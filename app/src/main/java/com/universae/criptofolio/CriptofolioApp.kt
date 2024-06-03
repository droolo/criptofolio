package com.universae.criptofolio

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CriptofolioApp:Application ()
{
    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()

        prefs = Prefs(applicationContext)
    }
}