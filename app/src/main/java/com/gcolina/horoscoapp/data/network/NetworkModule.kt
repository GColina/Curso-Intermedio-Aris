package com.gcolina.horoscoapp.data.network

import com.gcolina.horoscoapp.BuildConfig.BASE_URL
import com.gcolina.horoscoapp.data.RepositoryImplementation
import com.gcolina.horoscoapp.data.core.interceptors.AuthInterceptor
import com.gcolina.horoscoapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /*
        El Ktlint me lo cambia a Retrofit = Retrofit, pero es lo mismo a hacer un
        return Retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService =
        retrofit.create(HoroscopeApiService::class.java)

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository =
        RepositoryImplementation(apiService)
}
