package com.example.dictionaryapp.ui.view

import com.example.dictionaryapp.domain.currency.CurrencyEx
import com.example.dictionaryapp.domain.currency.CurrencyRates
import com.example.dictionaryapp.domain.exchange.Currency


interface MainActivityContract {

    //fun showData(rate: CurrencyRates)
    //fun showCurrency(currency: CurrencyEx)
    fun showDataApiLayer(currency: Currency)
    fun inputText(): Int

}