package com.mostafa.foodappf.data.netWorking.category

import com.mostafa.foodappf.data.model.Categories
import retrofit2.Response
import retrofit2.http.GET

interface ApiCategories {
    @GET("api/json/v1/1/categories.php")
    suspend fun getCategory(): Response<Categories>
}