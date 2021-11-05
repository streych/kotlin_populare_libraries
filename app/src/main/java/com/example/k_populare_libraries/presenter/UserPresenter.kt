package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GitUserInfo
import com.example.k_populare_libraries.repository.RetrofitGitUserInfo
import com.example.k_populare_libraries.view.UserInfoItemViewI
import com.example.k_populare_libraries.view.UserInfoListPresenterI
import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UsersViewI
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class UserPresenter( private val router: Router, val user: GithubUser
) :
    MvpPresenter<UsersViewI>() {

    class UserInfoListPresenter:  UserInfoListPresenterI {

        val repositories = mutableListOf<GitUserInfo>()

        override var itemClickListener: ((UserInfoItemViewI) -> Unit)? = null

        override fun bindView(view: UserInfoItemViewI) {
            val repository = repositories[view.pos]
            repository.name?.let { view.setNameRepo(it) }
        }

        override fun getCount() = repositories.size

    }

    val userInfoListPresenter = UserInfoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        userRepo.getUserInfo()
            .observeOn(uiScheduler)
            .subscribe({repo ->
                userInfoListPresenter.repositories.clear()
                userInfoListPresenter.repositories.addAll(repo)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

}