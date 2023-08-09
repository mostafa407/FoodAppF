package com.mostafa.foodappf.data.netWorking.meal

class ApiHelperMeal(private val apiMeals: ApiMeals) {
    suspend fun getMeals()=apiMeals.getMeals("Beef")
}