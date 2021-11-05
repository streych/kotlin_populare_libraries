package com.example.k_populare_libraries.view

import com.example.k_populare_libraries.data.GithubRepositoryInfo
import io.reactivex.rxjava3.core.Single

interface IGithubRepoInfo {
    fun getRepoInfo(): Single<List<GithubRepositoryInfo>>
}