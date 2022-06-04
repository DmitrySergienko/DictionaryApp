package com.example.dictionaryapp.data.retrofit.currency

import com.example.dictionaryapp.domain.currency.CurrencyEx
import com.example.dictionaryapp.domain.currency.CurrencyRates
import com.example.dictionaryapp.domain.exchange.Currency
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("exchange/rates")
    fun getData(@Query("apiKey") apiKey: String): Deferred<CurrencyRates>

    @GET("exchange/convert")
    fun getExCurrency(
        @Query("base") base: String,
        @Query("to") to: String,
        @Query("amount") amount: String,
        @Query("apiKey") apiKey: String,
    ) : Deferred<CurrencyEx>

    @GET("exchangerates_data/convert")
    fun getCurrency(
        @Query("to") to: String,
        @Query("from") from: String,
        @Query("amount") amount: String,
        @Header("apiKey") apiKey: String,
    ) : Deferred<Currency>
}