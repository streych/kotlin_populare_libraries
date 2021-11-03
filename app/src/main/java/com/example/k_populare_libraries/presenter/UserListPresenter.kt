package com.example.k_populare_libraries.presenter

import com.example.k_populare_libraries.data.GithubUser
import com.example.k_populare_libraries.view.UserItemViewI
import com.example.k_populare_libraries.view.UserListPresenterI

class UserListPresenter() : UserListPresenterI {

    val users = mutableListOf<GithubUser>()

    override var itemClickListener: ((UserItemViewI) -> Unit)? = null

    override fun bindView(view: UserItemViewI) {
        val user = users[view.pos]
        user.login?.let { view.setLogin(it) }
        user.avatarUrl?.let { view.loadAvatar(it) }
    }

    override fun getCount() = users.size

}