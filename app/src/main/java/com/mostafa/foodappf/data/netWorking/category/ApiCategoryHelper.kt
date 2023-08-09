package com.mostafa.foodappf.data.netWorking.category

class ApiCategoryHelper(private var apiCategories: ApiCategories) {
    suspend fun getCategory()=apiCategories.getCategory()
}