package com.mostafa.foodappf.data.repository

import com.mostafa.foodappf.data.netWorking.meal.ApiHelperMeal

class MealRepository(private val apiHelperMeal: ApiHelperMeal) {
    suspend fun getMeals()=apiHelperMeal.getMeals()
}