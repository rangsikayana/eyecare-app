package com.submission.eyecare.data.network

import com.submission.eyecare.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getRetrofit(baseUrl: String): Retrofit {
            val authInterceptor =
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                } else {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
                }
            val client = OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit
        }

        fun getService1(): ApiService {
            return getRetrofit(BuildConfig.BASE_URL).create(ApiService::class.java)
        }

        fun getService2(): ApiService {
            return getRetrofit(BuildConfig.MODEL_URL).create(ApiService::class.java)
        }
    }
}