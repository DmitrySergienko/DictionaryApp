package com.example.dictionaryapp.domain.currency


import kotlinx.coroutines.Deferred



interface GetCurrencyRep {

    suspend fun getCurrencyExRate() : Deferred<CurrencyRates>
}