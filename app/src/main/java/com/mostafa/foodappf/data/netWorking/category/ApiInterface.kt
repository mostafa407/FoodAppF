package com.mostafa.foodappf.data.netWorking.category

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder{
private const val BASE_URL="https://www.themealdb.com/"
fun getRetrofitBuilder():Retrofit{
return Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    }
val apiInterface= getRetrofitBuilder().create(ApiCategories::class.java)
}