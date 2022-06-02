package com.example.dictionaryapp.data

import com.example.dictionaryapp.domain.PersonEntity


    interface BaseRepo {

    fun getData(): PersonEntity
}