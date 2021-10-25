package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.repository.GithubUsersRepo
import com.example.k_populare_libraries.view.ScreensI
import com.example.k_populare_libraries.view.UsersViewI
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.PublishSubject
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
            router.navigateTo(screensI.user(userListPresenter.users[itemView.pos]), true)
        }


    }


    private fun loaData() {

        userRepo.getUsers().subscribe {
            userListPresenter.users.addAll(it)
        }

        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}



