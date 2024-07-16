package com.gcolina.horoscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.gcolina.horoscoapp.data.providers.HoroscopeProvider
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HoroscopeViewModel
@Inject
constructor(horoscopeProvider: HoroscopeProvider) :
    ViewModel() {
    // Curso Android 02:02:49

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {

        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}
