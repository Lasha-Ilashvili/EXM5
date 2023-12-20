package com.example.exm5.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiClient {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun courseService(): CourseService = retrofit.create(CourseService::class.java)
}