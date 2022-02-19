package com.learnig.android.cleanarchitecture.features.characters.domain

import com.learnig.android.cleanarchitecture.core.base.UseCase
import com.learnig.android.cleanarchitecture.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacter()
}