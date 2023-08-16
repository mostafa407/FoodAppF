package com.mostafa.foodappf.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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
import java.lang.reflect.Array.get


class MealsFragment : Fragment(),OnListClick {

    lateinit var binding:FragmentMealsBinding
    lateinit var viewModel:MealViewModel
    val mealList:ArrayList<Meals.Meal> =ArrayList()
    var mealsAdapter:MealAdapter=MealAdapter(mealList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentMealsBinding.inflate(inflater,container,false)
        val view=binding.root
        binding.lifecycleOwner=this
        val toolbar = binding.toolbarMeal

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this,MealViewModelFactory(
            ApiHelperMeal(ApiMealsBuilder.apiServiceMeal)
        ))[MealViewModel::class.java]
        val args = arguments
        val index = args?.getString("strCategory").toString()
        viewModel.getMeal(index)

        viewModel.meals.observe(viewLifecycleOwner, Observer {meals->

            mealsAdapter.list = meals.meals
            Log.d("meal",meals.toString())
        })
        mealsAdapter.onListClick=this
        val gridLayoutManager=GridLayoutManager(context,2)
        gridLayoutManager.orientation=GridLayoutManager.VERTICAL
        binding.recyclerMeal.adapter=mealsAdapter
        binding.recyclerMeal.setLayoutManager(gridLayoutManager)
        binding.recyclerMeal.addItemDecoration(
            DividerItemDecoration(context,GridLayoutManager.VERTICAL)
        )

    }

    override fun onMeal(meals: Meals.Meal) {
        val bundle:Bundle=Bundle()
        bundle.putInt("i",meals.idMeal!!.toInt())
        val transaction=activity?.supportFragmentManager?.beginTransaction()


            transaction?.replace(R.id.fram,DetailFragment(bundle))
            transaction?.disallowAddToBackStack()
            transaction?.commit()

    }
    companion object {
        // the name for the argument
        const val ARG_TEXT_TO_SHOW = "idmeal"

        // Use this function to create instances of the fragment
        // and set the passed data as arguments
        fun newInstance(textToShow: String) = MealsFragment().apply {
            arguments = bundleOf(
                ARG_TEXT_TO_SHOW to textToShow
            )
        }
    }


}