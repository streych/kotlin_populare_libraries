package com.example.k_populare_libraries.repository

import com.example.k_populare_libraries.data.GithubUser
import io.reactivex.rxjava3.core.Observable

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): Observable<List<GithubUser>> {
        return Observable.just(repositories)
    }

}