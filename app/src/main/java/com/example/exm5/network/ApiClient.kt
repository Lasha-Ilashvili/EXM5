package com.example.exm5.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiClient {

    private const val BASE_URL = ""

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

//    fun getRegisterResult(): RegisterService = retrofit.create(RegisterService::class.java)
//
//    fun getLoginResult(): LoginService = retrofit.create(LoginService::class.java)
}