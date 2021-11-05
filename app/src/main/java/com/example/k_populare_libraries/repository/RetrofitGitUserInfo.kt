package com.example.k_populare_libraries.repository

import com.example.k_populare_libraries.data.IDataSourceUserInfo
import com.example.k_populare_libraries.view.IGithubUserInfo
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGitUserInfo(val api_user_info: IDataSourceUserInfo) : IGithubUserInfo {
    override fun getUserInfo() = api_user_info.getUserInfo().subscribeOn(Schedulers.io())
}