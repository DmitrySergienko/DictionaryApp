package com.example.dictionaryapp.ui.presenters

import com.example.dictionaryapp.data.BaseRepo
import com.example.dictionaryapp.ui.view.MainActivityContract


class MainActivityPrecenter(private val repo: BaseRepo) : MainPresenterContract {

    private var activity: MainActivityContract? = null

    override fun attach(activity: MainActivityContract) {
        this.activity = activity
    }

    //get data from repo
    override fun getDataFromRepo() {
        val data = repo.getData() // take data from repo
        activity?.showData(data) //activity show data
    }

    override fun cancelActivity() {
        this.activity = null
    }
}