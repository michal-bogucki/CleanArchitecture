package com.learnig.android.cleanarchitecture.core.di

import com.learnig.android.cleanarchitecture.BuildConfig
import com.learnig.android.cleanarchitecture.features.data.RickAndMortyApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<Interceptor> {
        HttpLoggingInterceptor()
            .apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
            }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
    single {
        get<Retrofit>().create(RickAndMortyApi::class.java)
    }
}