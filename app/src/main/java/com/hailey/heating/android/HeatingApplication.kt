package com.hailey.heating.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * get the context
 */
class HeatingApplication : Application() {

    companion object{
        // get the context
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context

        // Api key of open weather
        const val TOKEN = "ELy7EHWKEUZNvzkB"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}