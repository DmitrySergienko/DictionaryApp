package com.example.dictionaryapp.domain.currency

import com.example.dictionaryapp.domain.exchange.Currency
import kotlinx.coroutines.Deferred


interface GetCurrencyRep {

    suspend fun getCurrencyExRate() : Deferred<CurrencyRates>
    suspend fun getExangeCurrency() : Deferred<CurrencyEx>
    suspend fun getCurrency() : Deferred<Currency>
}