package com.gcolina.horoscoapp.data.network.response

import com.gcolina.horoscoapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel = PredictionModel(
        horoscope = horoscope,
        sign = sign
    )
}
