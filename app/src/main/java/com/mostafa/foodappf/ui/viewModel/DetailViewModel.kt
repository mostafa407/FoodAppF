package com.mostafa.foodappf.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.foodappf.data.model.Details
import com.mostafa.foodappf.data.repository.DetailRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val detailRepository: DetailRepository):ViewModel() {
    val details=MutableLiveData<Details>()
    init {
        getDetail()
    }

    fun getDetail() {
        viewModelScope.launch {
            val response=detailRepository.getDetail()
            if (response.isSuccessful){
            details.postValue(response.body())
            }
        }

    }
}