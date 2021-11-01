package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UserViewI
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter( private val router: Router, val user: GithubUser
) :
    MvpPresenter<UserViewI>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        user.login?.let { viewState.setLogin(it) }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}