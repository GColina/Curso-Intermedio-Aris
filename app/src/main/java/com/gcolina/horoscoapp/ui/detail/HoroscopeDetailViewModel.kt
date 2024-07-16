package com.gcolina.horoscoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gcolina.horoscoapp.domain.model.HoroscopeModel
import com.gcolina.horoscoapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val getPredictionUseCase: GetPredictionUseCase
) : ViewModel() {

    private var _stateUi = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val stateUi: StateFlow<HoroscopeDetailState> = _stateUi

    lateinit var horoscope: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            // hilo principal
            _stateUi.value = HoroscopeDetailState.Loading
            // Hilo Secundario, por que estoy llamando al Dispatchers.IO,
            val result = withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) }

            if (result != null) {
                _stateUi.value =
                    HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            } else {
                _stateUi.value =
                    HoroscopeDetailState.Error("Ha ocurrido un error intentelo mas tarde")
            }
            // hilo principal
        }
    }
}
