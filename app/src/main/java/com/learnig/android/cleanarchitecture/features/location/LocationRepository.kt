package com.learnig.android.cleanarchitecture.features.location

import com.learnig.android.cleanarchitecture.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocation(): List<Location>
}