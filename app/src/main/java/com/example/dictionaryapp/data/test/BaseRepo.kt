package com.example.dictionaryapp.data.test

import com.example.dictionaryapp.domain.test.PersonEntity


    interface BaseRepo {

    fun getData(): PersonEntity
}