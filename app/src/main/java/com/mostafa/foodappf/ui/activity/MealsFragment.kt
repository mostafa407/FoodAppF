package com.mostafa.foodappf.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.mostafa.foodappf.R
import com.mostafa.foodappf.data.model.Meals
import com.mostafa.foodappf.data.netWorking.meal.ApiHelperMeal
import com.mostafa.foodappf.data.netWorking.meal.ApiMealsBuilder
import com.mostafa.foodappf.databinding.FragmentMealsBinding
import com.mostafa.foodappf.ui.adapter.MealAdapter
import com.mostafa.foodappf.ui.adapter.OnListClick
import com.mostafa.foodappf.ui.viewModel.MealViewModel
import com.mostafa.foodappf.ui.viewModel.MealViewModelFactory


class MealsFragment : Fragment(),OnListClick {

lateinit var binding:FragmentMealsBinding
lateinit var viewModel:MealViewModel
val mealList:ArrayList<Meals.Meal> =ArrayList()
var mealsAdapter:MealAdapter=MealAdapter(mealList)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=ViewModelProvider(this,MealViewModelFactory(
        ApiHelperMeal(ApiMealsBuilder.apiServiceMeal)
        ))[MealViewModel::class.java]
        binding= FragmentMealsBinding.inflate(inflater,container,false)
        val view=binding.root
        binding.lifecycleOwner=this
        val toolbar = binding.toolbarMeal
        viewModel.meals.observe(viewLifecycleOwner, Observer {meals->
            mealsAdapter.list=meals.meals
        })
        mealsAdapter.onListClick=this
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridLayoutManager=GridLayoutManager(context,2)
        gridLayoutManager.orientation=GridLayoutManager.VERTICAL
        binding.recyclerMeal.adapter=mealsAdapter
        binding.recyclerMeal.setLayoutManager(gridLayoutManager)
        binding.recyclerMeal.addItemDecoration(
            DividerItemDecoration(context,GridLayoutManager.VERTICAL)
        )

    }

    override fun onMeal(meals: Meals.Meal) {
        val transaction=activity?.supportFragmentManager?.beginTransaction()

            transaction?.replace(R.id.fram,DetailFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()

    }

}