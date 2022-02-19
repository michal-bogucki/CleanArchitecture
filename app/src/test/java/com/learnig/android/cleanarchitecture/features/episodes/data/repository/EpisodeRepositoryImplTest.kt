package com.learnig.android.cleanarchitecture.features.episodes.data.repository

import com.learnig.android.cleanarchitecture.core.api.RickAndMortyApi
import com.learnig.android.cleanarchitecture.core.api.model.episode.EpisodesResponse
import com.learnig.android.cleanarchitecture.core.network.NetworkStateProvider
import com.learnig.android.cleanarchitecture.features.episodes.data.local.dao.EpisodeDao
import com.learnig.android.cleanarchitecture.features.episodes.data.local.model.EpisodeCached
import com.learnig.android.cleanarchitecture.features.episodes.domain.EpisodeRepository
import com.learnig.android.cleanarchitecture.mock.mock
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EpisodeRepositoryImplTest{
    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`(){
        val api = mockk<RickAndMortyApi>{
            coEvery { getEpisode() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>{
            every { isNetworkAvailable() } returns true
        }

        val repository :EpisodeRepository = EpisodeRepositoryImpl(api,episodeDao,networkStateProvider)

        runBlocking { repository.getEpisode() }


        coEvery { api.getEpisode() }
    }

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN save episodes to local database`(){
        val api = mockk<RickAndMortyApi>{
            coEvery { getEpisode() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>{
            every { isNetworkAvailable() } returns true
        }

        val repository :EpisodeRepository = EpisodeRepositoryImpl(api,episodeDao,networkStateProvider)

        runBlocking { repository.getEpisode() }


        coEvery { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch from local database`(){
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<EpisodeDao>{
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(),EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider>{
            every { isNetworkAvailable() } returns false
        }

        val repository :EpisodeRepository = EpisodeRepositoryImpl(api,episodeDao,networkStateProvider)

        runBlocking { repository.getEpisode() }


        coEvery { episodeDao.getEpisodes() }
    }
}