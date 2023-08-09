package com.mostafa.foodappf.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mostafa.foodappf.data.netWorking.meal.ApiHelperMeal
import com.mostafa.foodappf.data.repository.MealRepository

class MealViewModelFactory(private val apiHelperMeal: ApiHelperMeal):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealViewModel::class.java)){
            return MealViewModel(MealRepository(apiHelperMeal)) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}