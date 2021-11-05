package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GitUserInfo
import com.example.k_populare_libraries.repository.RetrofitGitUserInfo
import com.example.k_populare_libraries.view.ScreensI
import com.example.k_populare_libraries.view.UserInfoItemViewI
import com.example.k_populare_libraries.view.UserInfoListPresenterI
import com.example.k_populare_libraries.view.UsersViewI
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class UserPresenter( private val router: Router, val user: GithubUser
) :
    MvpPresenter<UsersViewI>() {

    class UserInfoListPresenter : UserInfoListPresenterI {

        val repositories = mutableListOf<GitUserInfo>()

        override var itemClickListener: ((UserInfoItemViewI) -> Unit)? = null

        override fun bindView(view: UserInfoItemViewI) {
            val repository = repositories[view.pos]
            repository.name?.let { view.setNameRepo(it) }
        }

        override fun getCount() = repositories.size

    }

    val userInfoListPresenter = UserInfoListPresenter()

    //Я хрен его знает как сюда получить usersPresenter login
    //НИКТО НЕ ОТВЕЧАЕТ МНЕ НОРМАЛЬНО. ТОЛЬКО ССЫЛКАМИ РАСКИДЫВАЮТСЯ.
    var login: String = "streych"

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        login?.let {
            userRepo.getUserInfo(it)
                .observeOn(uiScheduler)
                .subscribe({ repo ->
                    userInfoListPresenter.repositories.clear()
                    userInfoListPresenter.repositories.addAll(repo)
                    viewState.updateList()
                }, {
                    println("Error: ${it.message}")
                })
        }

        userInfoListPresenter.itemClickListener = { itemView ->
            val user = userInfoListPresenter.repositories[itemView.pos]
            router.navigateTo(screensI.repositoryInfo(user))
        }


    }

}