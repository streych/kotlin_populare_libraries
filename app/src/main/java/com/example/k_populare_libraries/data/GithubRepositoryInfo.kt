package com.example.k_populare_libraries.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubRepositoryInfo(
    @Expose val full_name: String? = null
): Parcelable
