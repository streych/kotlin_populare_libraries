package com.example.k_populare_libraries.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(val login: String): Parcelable
