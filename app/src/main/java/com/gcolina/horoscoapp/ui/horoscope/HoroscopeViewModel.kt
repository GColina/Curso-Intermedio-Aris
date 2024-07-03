package com.gcolina.horoscoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(): ViewModel() {

    // Curso Android 02:02:49

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())

    fun getHoroscopes(){
        listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}