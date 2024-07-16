package com.gcolina.horoscoapp.domain.usecase

import com.gcolina.horoscoapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}

/* Se crea este suspend operator fun para cuando sea llamado dentro del View Model se pueda
    llamar sin tener que llamar a la funcion, pura estetica queda mas profesional.   */
