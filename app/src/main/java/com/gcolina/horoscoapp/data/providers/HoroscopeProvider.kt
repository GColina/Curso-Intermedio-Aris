@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.gcolina.horoscoapp.data.providers

import com.gcolina.horoscoapp.domain.model.HoroscopeInfo
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> = listOf(
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
