package com.learnig.android.cleanarchitecture.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharactersUseCaseTest{
    @Test
    fun `when use case is invoke than execute getCharacter method from repository`() {
        //give
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)
        //when
        useCase(params = Unit, scope = GlobalScope)

        //then
        coVerify {
            repository.getCharacter()
        }


    }
}