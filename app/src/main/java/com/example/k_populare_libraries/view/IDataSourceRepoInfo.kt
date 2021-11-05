package com.example.k_populare_libraries.view

import com.example.k_populare_libraries.data.GithubRepositoryInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSourceRepoInfo {

    @GET("/repos/streych/APPNOTE")
    fun getUserInfo(
    ): Single<List<GithubRepositoryInfo>>
}