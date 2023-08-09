package com.mostafa.foodappf.data.netWorking.details

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {
    private const val BASE_URL="https://www.themealdb.com/"
    fun getDetailRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiServiceDetails= getDetailRetrofit().create(ApiDetails::class.java)
}