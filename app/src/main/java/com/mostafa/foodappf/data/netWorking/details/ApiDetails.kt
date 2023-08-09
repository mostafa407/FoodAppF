package com.mostafa.foodappf.data.netWorking.details

import com.mostafa.foodappf.data.model.Details
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDetails {
    @GET("api/json/v1/1/lookup.php{i}")
    suspend fun getDetail(@Query("i")i:Int):Response<Details>
}