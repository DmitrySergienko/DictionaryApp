package com.example.dictionaryapp


import com.example.dictionaryapp.ui.presenters.MainPresenterContract
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


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
    fun testWithMock() {
        val mock = mock(TestInterface::class.java)
        Mockito.`when`(mock.test()).thenReturn("test2")

        val targetClass = TargetClass(mock)
        targetClass.doAction()

        verify(mock).test2("test2 handled")

    }


    @Test //Проверим вызов метода getDataApiLayer()
    fun getDataApiLayer_Test() {
        val mock = mock(MainPresenterContract::class.java)
        Mockito.`when`(mock.cancelActivity()).thenReturn(Unit)
    }


    //Fake test
    @Test
    fun testWithFake() {
        val dependency = FakeTestInterface()
        val targetClass = TargetClass(dependency)
        targetClass.doAction()

        assertEquals("test handled", dependency.lastTest2)

    }
}

interface TestInterface {
    fun test(): String
    fun test2(str: String)
}




