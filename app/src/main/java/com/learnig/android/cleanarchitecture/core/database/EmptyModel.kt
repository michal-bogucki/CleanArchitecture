package com.learnig.android.cleanarchitecture.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmptyModel(
    @PrimaryKey
    val id: Int = 0
)
