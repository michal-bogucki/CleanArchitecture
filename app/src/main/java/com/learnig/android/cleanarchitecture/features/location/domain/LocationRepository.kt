package com.learnig.android.cleanarchitecture.features.location.domain

import com.learnig.android.cleanarchitecture.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocation(): List<Location>
}