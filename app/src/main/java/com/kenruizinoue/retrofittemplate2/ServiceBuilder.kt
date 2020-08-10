package com.kenruizinoue.retrofittemplate2

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    fun create(): ApiService {

        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/")
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}