package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UserViewI
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter( private val router: Router
) :
    MvpPresenter<UserViewI>() {

}