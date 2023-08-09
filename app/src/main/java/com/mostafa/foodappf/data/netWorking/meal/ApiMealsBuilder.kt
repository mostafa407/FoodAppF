package com.mostafa.foodappf.data.netWorking.meal

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiMealsBuilder {
private const val BASE_URL="https://www.themealdb.com/"
fun getRetrofitBuilderMeal():Retrofit{
return Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}
    val apiServiceMeal= getRetrofitBuilderMeal().create(ApiMeals::class.java)
}