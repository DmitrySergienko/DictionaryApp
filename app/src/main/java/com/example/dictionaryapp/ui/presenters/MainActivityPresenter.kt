package com.example.dictionaryapp.ui.presenters

import com.example.dictionaryapp.domain.currency.GetCurrencyRep
import com.example.dictionaryapp.ui.view.MainActivityContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivityPresenter(private val repo: GetCurrencyRep) : MainPresenterContract {

    //Здесь будет ссылка на наше активити
    private var activity: MainActivityContract? = null

    //attach link to UI (MainActivity)
    //Этот метод будет вызыватся в активити и в параметр будет передеваться ссылка на активити через this
    override fun attach(activity: MainActivityContract) {
        this.activity  = activity
    }


    override fun getDataApiLayer() {
        GlobalScope.launch(Dispatchers.Main){

            val data = activity?.inputText()?.let { repo.getCurrency(it).await() }
            if (data != null) {
                activity?.showDataApiLayer(data)

            }
        }
    }

    //to deactivate activity (when activity is destroyed
    override fun cancelActivity() {
        this.activity = null
    }

    override fun inputAmount(t: Int): Int? {
        return activity?.inputText()
    }

}