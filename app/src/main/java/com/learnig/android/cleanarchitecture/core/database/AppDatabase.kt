package com.learnig.android.cleanarchitecture.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learnig.android.cleanarchitecture.core.database.AppDatabase.Companion.DB_VERSION


@Database(entities = [], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_VERSION = 1
    }
}