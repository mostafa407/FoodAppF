package com.mostafa.foodappf.ui.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodappf.data.model.Categories
import com.mostafa.foodappf.data.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository):ViewModel() {
    val category= MutableLiveData<Categories>()
    init {
        getCategory()
    }
    @SuppressLint("SuspiciousIndentation")
    fun getCategory(){
        viewModelScope.launch {
        val response=categoryRepository.getCategory()
            if (response.isSuccessful){
                category.postValue(response.body())
                Log.d("result", response.body().toString())

            }
}
    }
}