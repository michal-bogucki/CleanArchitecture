package com.learnig.android.cleanarchitecture.features.episodes.domain

import com.learnig.android.cleanarchitecture.features.episodes.EpisodeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodeUseCaseTest {

    @Test
    fun `when use case is invoke than execute getEpisodes method from repository`() {
        //give
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodeUseCase(repository)
        //when
        useCase(params = Unit, scope = GlobalScope)

        //then
        coVerify {
            repository.getEpisode()
        }


    }
}