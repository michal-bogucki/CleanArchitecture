package com.learnig.android.cleanarchitecture.features.episodes.domain

import com.learnig.android.cleanarchitecture.core.base.UseCase
import com.learnig.android.cleanarchitecture.features.episodes.EpisodeRepository
import com.learnig.android.cleanarchitecture.features.episodes.domain.model.Episode

class GetEpisodeUseCase(private val episodeRepository: EpisodeRepository):
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisode()


}