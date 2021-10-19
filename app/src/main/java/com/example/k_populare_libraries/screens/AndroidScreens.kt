package com.example.k_populare_libraries.screens

import com.example.k_populare_libraries.UserFragment
import com.example.k_populare_libraries.UsersFragment
import com.example.k_populare_libraries.view.ScreensI
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : ScreensI {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user() = FragmentScreen { UserFragment()}
}