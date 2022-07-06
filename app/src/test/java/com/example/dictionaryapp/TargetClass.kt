package com.example.dictionaryapp

class TargetClass(private val dependency: TestInterface) {
    fun doAction() {
        val test = dependency.test()
        val handled = "$test handled"
        dependency.test2(handled)
    }
}