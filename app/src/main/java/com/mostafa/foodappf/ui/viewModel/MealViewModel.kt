package com.mostafa.foodappf.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodappf.data.model.Meals
import com.mostafa.foodappf.data.repository.MealRepository
import kotlinx.coroutines.launch

class MealViewModel(private val mealRepository: MealRepository): ViewModel() {
    val meals=MutableLiveData<Meals>()

    fun getMeal(c:String){
        viewModelScope.launch {
            val respone=mealRepository.getMeals(c)
            if (respone.isSuccessful){
                meals.postValue(respone.body())
                Log.d("vi",respone.body().toString())
            }
        }
    }
}