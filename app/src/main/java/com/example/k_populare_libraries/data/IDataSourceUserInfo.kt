package com.example.k_populare_libraries.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSourceUserInfo {
    @GET("/users/{username}/{repos}")
    fun getUserInfo(
        @Path("username") username: String,
        @Path("repos") repos: String = "repos"
    ): Single<List<GitUserInfo>>
}