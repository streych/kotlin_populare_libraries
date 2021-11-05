package com.example.k_populare_libraries.repository

import com.example.k_populare_libraries.view.IDataSourceRepoInfo
import com.example.k_populare_libraries.view.IGithubRepoInfo
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGitRepoInfo(val api_repo_info: IDataSourceRepoInfo) : IGithubRepoInfo {
    override fun getRepoInfo() =
        api_repo_info.getUserInfo().subscribeOn(Schedulers.io())
}