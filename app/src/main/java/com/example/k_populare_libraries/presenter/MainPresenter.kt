package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.view.MainViewI
import com.example.k_populare_libraries.view.ScreensI
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: ScreensI) : MvpPresenter<MainViewI>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}