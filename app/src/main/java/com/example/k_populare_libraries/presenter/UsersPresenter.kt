package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.repository.GithubUsersRepo
import com.example.k_populare_libraries.view.ScreensI
import com.example.k_populare_libraries.view.UsersViewI
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class UsersPresenter(
    val userRepo: GithubUsersRepo,
    val router: Router,
    val screensI: ScreensI
) :
    MvpPresenter<UsersViewI>() {

    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loaData()

        userListPresenter.itemClickListener = { itemView ->

            //Log.d("TAG", userRepo.getUsers().get(itemView.pos).login)
            router.navigateTo(screensI.user(userListPresenter.users[itemView.pos]), true)
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