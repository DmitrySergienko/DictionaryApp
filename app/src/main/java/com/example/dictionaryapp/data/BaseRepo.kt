package com.example.dictionaryapp.data

import com.example.dictionaryapp.domain.test.PersonEntity


    interface BaseRepo {

    fun getData(): PersonEntity
}