package com.learnig.android.cleanarchitecture.core.api

import com.learnig.android.cleanarchitecture.core.api.model.episode.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisode(): EpisodesResponse
}