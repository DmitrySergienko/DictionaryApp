package com.example.dictionaryapp.ui.view

import com.example.dictionaryapp.domain.PersonEntity


interface MainActivityContract {

    fun showData(personEntity: PersonEntity)
}