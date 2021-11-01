package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.repository.RetrofitGithubUsersRepo
import com.example.k_populare_libraries.view.ScreensI
import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UserListPresenterI
import com.example.k_populare_libraries.view.UsersViewI
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter


class UsersPresenter(
    val uiScheduler: Scheduler,
    val userRepo: RetrofitGithubUsersRepo,
    val router: Router,
    val screensI: ScreensI
) :
    MvpPresenter<UsersViewI>() {
    class UsersListPresenter : UserListPresenterI {

        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemViewI) -> Unit)? = null

        override fun bindView(view: UserItemViewI) {
            val user = users[view.pos]
            user.login?.let { view.setLogin(it) }
        }

        override fun getCount() = users.size

    }

    val usersListPresenter = UsersListPresenter()
    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loaData()

        userListPresenter.itemClickListener = { itemView ->
             router.navigateTo(screensI.user(userListPresenter.users[itemView.pos]), true)
         }


        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(screensI.user(user))
        }
    }

    private fun loaData() {

        userRepo.getUsers()
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(repos)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}



