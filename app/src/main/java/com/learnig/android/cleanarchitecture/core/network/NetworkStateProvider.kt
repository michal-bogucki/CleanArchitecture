package com.learnig.android.cleanarchitecture.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable():Boolean
}