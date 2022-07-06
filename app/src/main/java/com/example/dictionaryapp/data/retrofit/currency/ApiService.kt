package com.example.dictionaryapp.data.retrofit.currency

import com.example.dictionaryapp.domain.currency.CurrencyRates
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

@GET("exchange/rates")
fun getData(@Query("apiKey") apiKey: String): Deferred<CurrencyRates>
}