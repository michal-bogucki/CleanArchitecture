package com.learnig.android.cleanarchitecture.features.characters.domain

import com.learnig.android.cleanarchitecture.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacter(): List<Character>
}