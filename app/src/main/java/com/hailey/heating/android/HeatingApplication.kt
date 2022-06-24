package com.hailey.heating.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class HeatingApplication : Application() {

    companion object{
        // get the context
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context

        // Api key of open weather
        const val TOKEN = "fac5815dadf86d0708143a8efce06f67\n"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}