package com.learnig.android.cleanarchitecture.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    networkModule,appModule,roomModule
)