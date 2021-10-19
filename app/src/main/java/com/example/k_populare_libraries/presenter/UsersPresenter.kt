package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.repository.GithubUsersRepo
import com.example.k_populare_libraries.view.ScreensI
import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UserListPresenterI
import com.example.k_populare_libraries.view.UsersViewI
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val userRepo: GithubUsersRepo, val router: Router, val screensI: ScreensI) :
    MvpPresenter<UsersViewI>() {

    class UserListPresenter : UserListPresenterI {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemViewI) -> Unit)? = null

        override fun bindView(view: UserItemViewI) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loaData()

        userListPresenter.itemClickListener = { itemView ->

            router.setResultListener("STRING") {


            }
            router.navigateTo(screensI.user())
        }
    }

    private fun loaData() {
        val users = userRepo.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}