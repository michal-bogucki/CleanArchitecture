package com.learnig.android.cleanarchitecture.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.learnig.android.cleanarchitecture.core.database.AppDatabase.Companion.DB_VERSION
import com.learnig.android.cleanarchitecture.features.episodes.data.local.dao.EpisodeDao
import com.learnig.android.cleanarchitecture.features.episodes.data.local.model.EpisodeCached


@Database(entities = [EpisodeCached::class], version = DB_VERSION)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao

    companion object {
        const val DB_VERSION = 1
    }
}