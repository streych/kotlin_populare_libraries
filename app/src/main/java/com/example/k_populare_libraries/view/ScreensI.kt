package com.example.k_populare_libraries.view

import com.example.k_populare_libraries.data.GitUserInfo
import com.example.k_populare_libraries.data.GithubUser
import com.github.terrakok.cicerone.Screen

interface ScreensI {
    fun users(): Screen
    fun user(user : GithubUser): Screen
    fun repositoryInfo(rInfo : GitUserInfo): Screen
}