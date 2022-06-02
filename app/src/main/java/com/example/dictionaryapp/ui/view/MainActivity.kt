package com.example.dictionaryapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionaryapp.App
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.example.dictionaryapp.domain.PersonEntity

class MainActivity : AppCompatActivity(), MainActivityContract {

    // create presenter
    private val presenter = App.instance.precenter

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attach(this) //connect presenter

        binding.button.setOnClickListener {
            presenter.getDataFromRepo()
        }

    }

    override fun showData(personEntity: PersonEntity) {
        binding.textView.text = personEntity.toString()
    }

    override fun onDestroy() {
        presenter.cancelActivity() // detach activity if destroyed
        super.onDestroy()
    }
}