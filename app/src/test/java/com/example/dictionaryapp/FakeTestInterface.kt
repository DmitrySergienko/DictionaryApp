package com.example.dictionaryapp

class FakeTestInterface : TestInterface {

    var lastTest2: String? = null

    override fun test(): String {
        return "test"
    }

    override fun test2(str: String) {
        lastTest2 = str
    }

}