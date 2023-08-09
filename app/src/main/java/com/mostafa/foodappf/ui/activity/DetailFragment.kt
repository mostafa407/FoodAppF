package com.mostafa.foodappf.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mostafa.foodappf.R
import com.mostafa.foodappf.data.netWorking.details.ApiDetailsHelper
import com.mostafa.foodappf.data.netWorking.details.RetrofitBuilder
import com.mostafa.foodappf.databinding.FragmentDetailBinding
import com.mostafa.foodappf.ui.viewModel.DetailViewModel
import com.mostafa.foodappf.ui.viewModel.DetailViewModelFactory


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var viewModel:DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=ViewModelProvider(this,
        DetailViewModelFactory(ApiDetailsHelper(RetrofitBuilder.apiServiceDetails)))[DetailViewModel::class.java]
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.lifecycleOwner=this
        viewModel.details.observe(viewLifecycleOwner, Observer {details->
            binding.Category.text=details.meals[0].strCategory
            Glide.with(this).asBitmap().load(details.meals[0].strMealThumb).into(binding.imgDetails)
            binding.Ingredient1.text=details.meals[0].strIngredient1
            binding.Ingredient2.text=details.meals[0].strIngredient2
            binding.Ingredient3.text=details.meals[0].strIngredient3
            binding.strInstructions.text=details.meals[0].strInstructions
        })
        return view


    }
}