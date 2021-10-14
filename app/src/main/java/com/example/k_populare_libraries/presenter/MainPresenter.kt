package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.model.CountersModel
import com.example.k_populare_libraries.view.MainView

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterClick(type: CounterType) {
        //Логика что делать по нажатю кнопки
        val nextValue = when (type) {
            CounterType.TAPME1 -> model.next(0)
            CounterType.TAPME2 -> model.next(1)
            CounterType.TAPME3 -> model.next(2)
        }

        view.apply {
            setButtonText1(nextValue.toString())
            setButtonText2(nextValue.toString())
            setButtonText3(nextValue.toString())
        }
    }
}

enum class CounterType {
    TAPME1,
    TAPME2,
    TAPME3
}