package com.example.dictionaryapp

import com.example.dictionaryapp.domain.currency.GetCurrencyRep
import com.example.dictionaryapp.ui.presenters.MainActivityPresenter
import com.example.dictionaryapp.ui.view.MainActivityContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TestPresenter {

    private lateinit var presenter: MainActivityPresenter
    @Mock
    private lateinit var repository: GetCurrencyRep

    //Здесь будет ссылка на наше активити
    var activity: MainActivityContract? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        //Создаем Презентер
        presenter = MainActivityPresenter(repository)
    }

    @Test //Проверим вызов метода getExangeCurrency()
    fun getExchangeCurrency_Test() {

        GlobalScope.launch {Dispatchers.Main
            Mockito.verify(presenter.getDataApiLayer(), Mockito.atLeast(1))
        }

    }



    @Test
    fun cancelActivity_Test() {
        presenter.cancelActivity()
        Mockito.verify(this.activity, null)
    }
}