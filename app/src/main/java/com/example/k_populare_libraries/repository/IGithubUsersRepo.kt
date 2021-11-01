package com.example.k_populare_libraries.repository

import com.example.k_populare_libraries.data.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}