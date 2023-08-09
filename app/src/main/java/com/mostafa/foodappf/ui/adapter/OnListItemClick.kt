package com.mostafa.foodappf.ui.adapter

import com.mostafa.foodappf.data.model.Categories
import com.mostafa.foodappf.data.model.Meals

interface OnListItemClick {
    fun onItem(categories: Categories.Category)
}
interface OnListClick{
    fun onMeal(meals: Meals.Meal)
}