package com.learnig.android.cleanarchitecture.core.api.model.episode

import com.google.gson.annotations.SerializedName
import com.learnig.android.cleanarchitecture.core.api.model.ResponseInfo

class EpisodesResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
){
    companion object
}