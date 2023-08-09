package com.mostafa.foodappf.data.repository

import com.mostafa.foodappf.data.netWorking.category.ApiCategoryHelper

class CategoryRepository(private val apiCategoryHelper: ApiCategoryHelper) {
    suspend fun getCategory()=apiCategoryHelper.getCategory()
}