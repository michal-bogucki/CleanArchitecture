package com.learnig.android.cleanarchitecture.features.episodes.domain

import com.learnig.android.cleanarchitecture.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisode(): List<Episode>
}