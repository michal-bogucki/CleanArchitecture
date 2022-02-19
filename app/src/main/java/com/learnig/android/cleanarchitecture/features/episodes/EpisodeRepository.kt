package com.learnig.android.cleanarchitecture.features.episodes

import com.learnig.android.cleanarchitecture.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisode(): List<Episode>
}