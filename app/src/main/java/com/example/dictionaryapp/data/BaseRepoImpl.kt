package com.example.dictionaryapp.data

import com.example.dictionaryapp.domain.test.PersonEntity


class BaseRepoImpl:BaseRepo {
    //return person name
    override fun getData(): PersonEntity = PersonEntity("Name")


}