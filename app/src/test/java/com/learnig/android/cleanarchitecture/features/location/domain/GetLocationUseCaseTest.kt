package com.learnig.android.cleanarchitecture.features.location.domain

import com.learnig.android.cleanarchitecture.features.episodes.EpisodeRepository
import com.learnig.android.cleanarchitecture.features.episodes.domain.GetEpisodeUseCase
import com.learnig.android.cleanarchitecture.features.location.LocationRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GetLocationUseCaseTest {


    @Test
    fun `when use case is invoke than execute getLocation method from repository`() {
        //give
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationUseCase(repository)
        //when
        useCase(params = Unit, scope = GlobalScope)

        //then
        coVerify {
            repository.getLocation()
        }


    }
}