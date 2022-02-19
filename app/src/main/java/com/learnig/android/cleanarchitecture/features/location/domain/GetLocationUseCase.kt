package com.learnig.android.cleanarchitecture.features.location.domain

import com.learnig.android.cleanarchitecture.core.base.UseCase
import com.learnig.android.cleanarchitecture.features.location.domain.model.Location

class GetLocationUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocation()
}

