package com.example.k_populare_libraries.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserViewI : MvpView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}