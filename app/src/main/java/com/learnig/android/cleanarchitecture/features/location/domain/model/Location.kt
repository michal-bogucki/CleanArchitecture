package com.learnig.android.cleanarchitecture.features.location.domain.model

import androidx.room.PrimaryKey

data class Location(
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)
