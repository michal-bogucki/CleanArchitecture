package com.learnig.android.cleanarchitecture.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.learnig.android.cleanarchitecture.core.network.NetworkStateProvider
import com.learnig.android.cleanarchitecture.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidApplication

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory {
        LinearLayoutManager(androidContext())
    }

    factory {
        GridLayoutManager(androidContext(), 2)
    }

    factory {
        DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL)
    }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
}