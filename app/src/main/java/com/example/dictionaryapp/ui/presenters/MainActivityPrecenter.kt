package com.example.dictionaryapp.ui.presenters

import com.example.dictionaryapp.data.BaseRepo
import com.example.dictionaryapp.ui.view.MainActivityContract


class MainActivityPrecenter(private val repo: BaseRepo) : MainPresenterContract {

    //Здесь будет ссылка на наше активити
    private var activity: MainActivityContract? = null

    //attach link to UI (MainActivity)
    //Этот метод буде вызыватся в активити и в параметр будет передеваться ссылка на активити через this
    override fun attach(activity: MainActivityContract) {
        this.activity = activity
    }

    //send request to Database
    override fun getDataFromRepo() {
        val data = repo.getData() // take data from repo
        activity?.showData(data) //activity show data
    }
    //to swith off activity (when activity is destroyed
    override fun cancelActivity() {
        this.activity = null
    }
}