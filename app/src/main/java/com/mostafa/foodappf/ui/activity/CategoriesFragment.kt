package com.mostafa.foodappf.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mostafa.foodappf.R
import com.mostafa.foodappf.data.model.Categories
import com.mostafa.foodappf.data.netWorking.category.ApiCategoryHelper
import com.mostafa.foodappf.data.netWorking.category.RetrofitBuilder
import com.mostafa.foodappf.databinding.FragmentCategoriesBinding
import com.mostafa.foodappf.ui.adapter.CategoryAdapter
import com.mostafa.foodappf.ui.adapter.OnListItemClick
import com.mostafa.foodappf.ui.viewModel.CategoryViewModel
import com.mostafa.foodappf.ui.viewModel.CategoryViewModelFactory


class CategoriesFragment:Fragment(),OnListItemClick{
    lateinit var binding:FragmentCategoriesBinding
    lateinit var viewModel: CategoryViewModel
    var categorieslist: ArrayList<Categories.Category> = ArrayList()
    var   categoryRecyclerView:CategoryAdapter = CategoryAdapter(categorieslist)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= FragmentCategoriesBinding.inflate(inflater,container,false)
        val view=binding.root
       binding.lifecycleOwner=this
        val toolbar = binding?.toolbar
        if (toolbar != null) {
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this, CategoryViewModelFactory(
                ApiCategoryHelper(RetrofitBuilder.apiInterface)
            )
        )[CategoryViewModel::class.java]
        val linearLayoutManager = GridLayoutManager(context,2)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recycler.adapter=categoryRecyclerView
        binding.recycler.setLayoutManager(linearLayoutManager)
        Log.d("TEST1","${binding.recycler}")

        binding.recycler.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        viewModel.category.observe(viewLifecycleOwner, Observer { categories ->
            categoryRecyclerView.list=categories.categories
            Log.d("main", categories.toString())
        })
        categoryRecyclerView.onListItemClick=this
    }

    override fun onItem(categories: Categories.Category) {
//        val bundle=Bundle()
//        bundle.putString("strCategory",categories.strCategory)
     //  val fragment=CategoriesFragment.newInstance(categories.strCategory)
        val fragment=MealsFragment.newInstance(categories.strCategory)
     val transaction= activity?.supportFragmentManager?.beginTransaction()
        if (transaction != null) {

            transaction.replace(R.id.fram,fragment)
            transaction.disallowAddToBackStack()
            transaction.commit()
        }
    }
    companion object {
        const val ARG_TEXT_TO_SHOW = "strCategory"
        fun newInstance(c: String) = CategoriesFragment().apply {
            val args = Bundle()
            args.putString(ARG_TEXT_TO_SHOW, c)


        }
    }

}
