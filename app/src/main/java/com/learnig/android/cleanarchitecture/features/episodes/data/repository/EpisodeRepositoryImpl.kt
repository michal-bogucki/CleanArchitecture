package com.learnig.android.cleanarchitecture.features.episodes.data.repository

import com.learnig.android.cleanarchitecture.core.api.RickAndMortyApi
import com.learnig.android.cleanarchitecture.core.network.NetworkStateProvider
import com.learnig.android.cleanarchitecture.features.episodes.data.local.dao.EpisodeDao
import com.learnig.android.cleanarchitecture.features.episodes.data.local.model.EpisodeCached
import com.learnig.android.cleanarchitecture.features.episodes.domain.EpisodeRepository
import com.learnig.android.cleanarchitecture.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : EpisodeRepository {
    override suspend fun getEpisode(): List<Episode> {
        return if(networkStateProvider.isNetworkAvailable()){
            getEpisodesFromRemote()
                .also { saveEpisodeToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisode()
            .results
            .map { it.toEpisode() }

    }

    private suspend fun saveEpisodeToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes().map { it.toEpisode() }
    }
}