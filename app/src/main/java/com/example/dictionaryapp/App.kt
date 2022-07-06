package com.example.dictionaryapp

import android.app.Application

import com.example.dictionaryapp.data.retrofit.currency.RetrofitCurrencyImpl
import com.example.dictionaryapp.ui.presenters.MainActivityPrecenter


class App: Application() {
    val precenter: MainActivityPrecenter by lazy {
        MainActivityPrecenter(RetrofitCurrencyImpl())
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    //Здесь у нас экземпляр нашего класса Application через который у нас будет доступ к нашим компонентам
    companion object{
        lateinit var instance:App
        private set
    }
}