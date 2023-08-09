package com.mostafa.foodappf.data.netWorking.meal

import com.mostafa.foodappf.data.model.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMeals {
    @GET("api/json/v1/1/filter.php")
    suspend fun getMeals(@Query("c")c :String):Response<Meals>
}