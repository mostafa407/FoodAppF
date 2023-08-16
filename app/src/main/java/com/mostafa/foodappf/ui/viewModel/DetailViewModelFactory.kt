package com.mostafa.foodappf.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mostafa.foodappf.data.netWorking.details.ApiDetailsHelper
import com.mostafa.foodappf.data.repository.DetailRepository

class DetailViewModelFactory(private val apiDetailsHelper: ApiDetailsHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(DetailRepository(apiDetailsHelper))as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}