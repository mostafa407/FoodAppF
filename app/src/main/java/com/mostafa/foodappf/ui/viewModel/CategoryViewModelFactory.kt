package com.mostafa.foodappf.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mostafa.foodappf.data.netWorking.category.ApiCategoryHelper
import com.mostafa.foodappf.data.repository.CategoryRepository

class CategoryViewModelFactory(private val apiCategoryHelper: ApiCategoryHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)){
            return CategoryViewModel(CategoryRepository(apiCategoryHelper)) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}