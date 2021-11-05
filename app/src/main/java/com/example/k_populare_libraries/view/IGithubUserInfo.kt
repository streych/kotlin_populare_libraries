package com.example.k_populare_libraries.view

import com.example.k_populare_libraries.data.GitUserInfo
import io.reactivex.rxjava3.core.Single

interface IGithubUserInfo {
    fun getUserInfo(): Single<List<GitUserInfo>>
}