package com.learnig.android.cleanarchitecture.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learnig.android.cleanarchitecture.core.database.AppDatabase.Companion.DB_VERSION
import com.learnig.android.cleanarchitecture.features.characters.domain.model.Character
import com.learnig.android.cleanarchitecture.features.episodes.domain.model.Episode
import com.learnig.android.cleanarchitecture.features.location.domain.model.Location


@Database(entities = [EmptyModel::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_VERSION = 1
    }
}