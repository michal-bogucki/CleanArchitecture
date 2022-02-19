package com.learnig.android.cleanarchitecture.features.location.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
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