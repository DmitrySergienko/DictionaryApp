package com.example.dictionaryapp.data.retrofit.currency

import com.example.dictionaryapp.domain.currency.CurrencyRates
import com.example.dictionaryapp.domain.currency.GetCurrencyRep
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_KEY = "ecmms3f5p42madoffj0g8c93qc2fs9rsgmi29vso715euu7jeapo"

class RetrofitCurrencyImpl : GetCurrencyRep {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://anyapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    private val api: ApiService = retrofit.create(ApiService::class.java)

    override suspend fun getCurrencyExRate(): Deferred<CurrencyRates> {
        return api.getData(API_KEY)
    }

}
