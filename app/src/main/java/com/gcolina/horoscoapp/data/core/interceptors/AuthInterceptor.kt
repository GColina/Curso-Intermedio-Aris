package com.gcolina.horoscoapp.data.core.interceptors

import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .header("Autorization", "dakhjgdajhsdbasd")
            .build()
        return chain.proceed(request)
    }
}
