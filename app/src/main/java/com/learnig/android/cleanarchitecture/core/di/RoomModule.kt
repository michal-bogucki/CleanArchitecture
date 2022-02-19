package com.learnig.android.cleanarchitecture.core.di

import androidx.room.Room
import com.learnig.android.cleanarchitecture.core.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java, "database"
        ).build()
    }

    single { get<AppDatabase>().episodeDao() }
}