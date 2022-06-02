package com.example.dictionaryapp.ui.presenters

import com.example.dictionaryapp.ui.view.MainActivityContract


interface MainPresenterContract {

    //attach link to UI (MainActivity)
    fun attach(activity: MainActivityContract)

    //send request to Database
    fun getDataFromRepo()

    //to swith off activity (when activity is destroyed
    fun cancelActivity()
}