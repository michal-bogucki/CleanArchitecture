package com.learnig.android.cleanarchitecture.core.app

import android.app.Application
import com.learnig.android.cleanarchitecture.core.di.koinInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startCoin()
    }

    private fun startCoin() {
        startKoin {
            androidContext(this@App)
            modules(koinInjector)
        }
    }
}