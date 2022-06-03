package com.example.dictionaryapp.ui.view

import com.example.dictionaryapp.domain.currency.CurrencyRates
import com.example.dictionaryapp.domain.test.PersonEntity
import kotlinx.coroutines.Deferred


interface MainActivityContract {

    fun showData(rate: CurrencyRates)
}