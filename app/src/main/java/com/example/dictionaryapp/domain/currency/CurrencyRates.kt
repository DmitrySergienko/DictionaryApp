package com.example.dictionaryapp.domain.currency

data class CurrencyRates(
	val lastUpdate: Int? = null,
	val rates: Rates? = null,
	val base: String? = null
)
