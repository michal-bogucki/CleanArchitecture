package com.learnig.android.cleanarchitecture.features.episodes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learnig.android.cleanarchitecture.features.episodes.data.local.model.EpisodeCached

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM EPISODECACHED")
    suspend fun getEpisodes(): List<EpisodeCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episodeCached: EpisodeCached)
}