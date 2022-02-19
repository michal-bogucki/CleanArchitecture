package com.learnig.android.cleanarchitecture.core.api.model
import com.google.gson.annotations.SerializedName


data class ResponseInfo(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("pages") val pages: Int,
    @SerializedName("prev") val prev: String?
){
    companion object
}