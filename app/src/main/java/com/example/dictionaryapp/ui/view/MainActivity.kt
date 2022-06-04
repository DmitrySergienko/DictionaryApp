package com.example.dictionaryapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionaryapp.App
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.example.dictionaryapp.domain.currency.CurrencyEx
import com.example.dictionaryapp.domain.currency.CurrencyRates
import com.example.dictionaryapp.domain.exchange.Currency
import com.example.dictionaryapp.domain.test.PersonEntity
import kotlinx.coroutines.Deferred

class MainActivity : AppCompatActivity(), MainActivityContract {

    // create presenter
    private val presenter = App.instance.precenter

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //connect presenter
        presenter.attach(this)

       initRate() //show currency rate
       initExchange() //show exchange

    }

    override fun onDestroy() {
        presenter.cancelActivity() // detach activity if destroyed
        super.onDestroy()
    }

    private fun initRate(){
        binding.button.setOnClickListener {
            presenter.getDataFromRepo()
        }
    }

    override fun showData(rate: CurrencyRates) {
//        runOnUiThread {
            binding.textView.text = rate.toString()
//        }
    }

    override fun showCurrency(currency: CurrencyEx) {

        binding.textViewExBase.text = currency.converted.toString()
        binding.textViewExTo.text = currency.to
        binding.textViewExAmount.text = currency.amount.toString()
    }

    override fun showDataApiLayer(currency: Currency) {
        binding.textViewExBase.text = currency.result.toString()

    }

    fun initExchange(){
        binding.buttonExCurrency.setOnClickListener {
            presenter.getDataApiLayer()
        }
    }
}