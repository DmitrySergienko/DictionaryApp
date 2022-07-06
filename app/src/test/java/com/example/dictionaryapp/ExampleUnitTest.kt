package com.example.dictionaryapp


import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)


    }

//Mock test
    @Test
    fun testWithMock(){
        val mock = mock(TestInterface::class.java)
        Mockito.`when`(mock.test()).thenReturn("test2")

        val targetClass = TargetClass(mock)
    targetClass.doAction()

    verify(mock).test2("testq2 handled")

    }

//Fake test
    @Test
    fun testWithFake(){
        val dependency = FakeTestInterface()
        val targetClass = TargetClass(dependency)
        targetClass.doAction()

        assertEquals("test handled",dependency.lastTest2)

    }


}
interface TestInterface{
    fun test(): String
    fun test2(str:String)
}


class TargetClass(private val dependency:TestInterface){
    fun doAction(){
        val test = dependency.test()
        val handled ="$test handled"
        dependency.test2(handled)
    }
}
//Fake Test

class FakeTestInterface : TestInterface {

    var lastTest2: String? = null

    override fun test(): String {
        return "test"
    }

    override fun test2(str: String) {
        lastTest2 = str
    }

}