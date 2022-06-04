package com.example.dictionaryapp.ui.view

import com.example.dictionaryapp.domain.currency.CurrencyEx
import com.example.dictionaryapp.domain.currency.CurrencyRates
import com.example.dictionaryapp.domain.exchange.Currency
import com.example.dictionaryapp.domain.test.PersonEntity
import kotlinx.coroutines.Deferred


interface MainActivityContract {

    fun showData(rate: CurrencyRates)
    fun showCurrency(currency: CurrencyEx)
    fun showDataApiLayer(currency: Currency)

}