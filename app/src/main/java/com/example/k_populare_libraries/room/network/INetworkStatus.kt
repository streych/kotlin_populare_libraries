package com.example.k_populare_libraries.room.network

import android.database.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject

interface INetworkStatus {

    fun isOnline(): BehaviorSubject<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}