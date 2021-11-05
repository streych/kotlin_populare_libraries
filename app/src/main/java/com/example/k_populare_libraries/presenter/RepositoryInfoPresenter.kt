package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GithubRepositoryInfo
import com.example.k_populare_libraries.repository.RetrofitGitRepoInfo
import com.example.k_populare_libraries.view.UserInfoItemViewI
import com.example.k_populare_libraries.view.UserInfoListPresenterI
import com.example.k_populare_libraries.view.UsersViewI
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class RepositoryInfoPresenter(
    val uiScheduler: Scheduler,
    val userRepo: RetrofitGitRepoInfo
) :
    MvpPresenter<UsersViewI>() {

    class UserInfoListPresenter : UserInfoListPresenterI {
        val repoInfo = mutableListOf<GithubRepositoryInfo>()
        override var itemClickListener: ((UserInfoItemViewI) -> Unit)? = null

        override fun bindView(view: UserInfoItemViewI) {

            val repository = repoInfo[view.pos]
            repository.full_name?.let { view.setNameRepo(it) }
        }

        override fun getCount() = repoInfo.size

    }

    val userInfoListPresenter = UserInfoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        userRepo.getRepoInfo()
            .observeOn(uiScheduler)
            .subscribe({ repo ->
                userInfoListPresenter.repoInfo.clear()
                userInfoListPresenter.repoInfo.addAll(repo)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

}