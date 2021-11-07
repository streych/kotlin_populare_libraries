package com.example.k_populare_libraries.room

import android.database.Observable
import io.reactivex.rxjava3.core.Single

interface INetworkStatus {

    fun isOnline(): Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}