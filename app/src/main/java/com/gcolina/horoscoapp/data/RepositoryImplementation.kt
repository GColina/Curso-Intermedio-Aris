package com.gcolina.horoscoapp.data

import android.util.Log
import com.gcolina.horoscoapp.data.network.HoroscopeApiService
import com.gcolina.horoscoapp.domain.Repository
import com.gcolina.horoscoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService) :
    Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            // Con estos dos metodos puedo ver si tengo algun error en la llamada
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("aris", "Haocurrido un error ${it.message}") }
        return null
    }
}
