package com.gcolina.horoscoapp.domain

import com.gcolina.horoscoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}
