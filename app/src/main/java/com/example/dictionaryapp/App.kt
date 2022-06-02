package com.example.dictionaryapp

import android.app.Application
import com.example.dictionaryapp.data.BaseRepoImpl
import com.example.dictionaryapp.ui.presenters.MainActivityPrecenter


class App: Application() {
    val precenter: MainActivityPrecenter by lazy {
        MainActivityPrecenter(BaseRepoImpl())
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object{
        lateinit var instance:App
        private set
    }
}