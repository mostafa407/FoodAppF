package com.mostafa.foodappf.data.netWorking.meal

class ApiHelperMeal(private val apiMeals: ApiMeals) {
    suspend fun getMeals(c:String)=apiMeals.getMeals(c)
}