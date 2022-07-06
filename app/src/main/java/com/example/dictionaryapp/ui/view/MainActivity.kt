package com.example.dictionaryapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionaryapp.App
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.example.dictionaryapp.domain.currency.CurrencyRates
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

       initWord() //

    }


    override fun onDestroy() {
        presenter.cancelActivity() // detach activity if destroyed
        super.onDestroy()
    }

    private fun initWord(){
        binding.button.setOnClickListener {
            presenter.getDataFromRepo()
        }
    }

    override fun showData(rate: CurrencyRates) {
//        runOnUiThread {
            binding.textView.text = rate.toString()
//        }
    }
}