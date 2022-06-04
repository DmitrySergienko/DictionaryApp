package com.example.dictionaryapp.data.retrofit.currency

import com.example.dictionaryapp.domain.currency.CurrencyEx
import com.example.dictionaryapp.domain.currency.CurrencyRates
import com.example.dictionaryapp.domain.currency.GetCurrencyRep
import com.example.dictionaryapp.domain.exchange.Currency
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//private const val API_KEY = "ecmms3f5p42madoffj0g8c93qc2fs9rsgmi29vso715euu7jeapo"
private const val API_KEY = "IMQ9MJKNI9l8X7hL00rkpwzofh8AFjUY"

class RetrofitCurrencyImpl : GetCurrencyRep {

    private val retrofit = Retrofit.Builder()
        //.baseUrl("https://anyapi.io/api/v1/")
        .baseUrl("https://api.apilayer.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    private val api: ApiService = retrofit.create(ApiService::class.java)

    override suspend fun getCurrencyExRate(): Deferred<CurrencyRates> {
        return api.getData(API_KEY)
    }

    override suspend fun getExangeCurrency(): Deferred<CurrencyEx> {
        return api.getExCurrency("USD","BGN","1000", API_KEY)
    }

    override suspend fun getCurrency(amount:Int): Deferred<Currency> {
        return api.getCurrency("RUB","AED","$amount", API_KEY)
    }
}
