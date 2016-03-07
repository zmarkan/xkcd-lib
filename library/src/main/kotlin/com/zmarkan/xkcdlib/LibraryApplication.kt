package com.zmarkan.xkcdlib

import android.app.Application
import android.util.Log

class LibraryApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(">>>>", ">>>> APP");
    }

}