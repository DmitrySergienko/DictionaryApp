package com.example.dictionaryapp.ui.presenters

import com.example.dictionaryapp.domain.currency.GetCurrencyRep
import com.example.dictionaryapp.ui.view.MainActivityContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivityPrecenter(private val repo: GetCurrencyRep) : MainPresenterContract {

    //Здесь будет ссылка на наше активити
    private var activity: MainActivityContract? = null

    //attach link to UI (MainActivity)
    //Этот метод буде вызыватся в активити и в параметр будет передеваться ссылка на активити через this
    override fun attach(activity: MainActivityContract) {
        this.activity = activity
    }

    //send request to Database
   /* override fun getDataFromRepo() {
        GlobalScope.launch(Dispatchers.Main) {
            val data = repo.getCurrencyExRate().await()
            activity?.showData(data)
        }
         // take data from repo
        //activity show data
    }

    override fun getDataFromCurrencyExchangeApi() {
        GlobalScope.launch(Dispatchers.Main){
            val data = repo.getExangeCurrency().await()
            activity?.showCurrency(data)
        }
    }
*/
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