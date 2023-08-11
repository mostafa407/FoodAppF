package com.mostafa.foodappf.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mostafa.foodappf.data.model.Categories
import com.mostafa.foodappf.data.model.Meals
import com.mostafa.foodappf.databinding.ListMealBinding

class MealAdapter(var list:ArrayList<Meals.Meal>):
    RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    var onListClick:OnListClick?=null
    inner class MealViewHolder(val listMealBinding: ListMealBinding)
        :RecyclerView.ViewHolder(listMealBinding.root){
        fun bind(item:Meals.Meal) {
            listMealBinding.model=item
            Glide.with(itemView.context).asBitmap().load(item.strMealThumb)
                .into(listMealBinding.strMealThumb)
            listMealBinding.strMeal.text=item.strMeal
            itemView.setOnClickListener {
                onListClick?.onMeal(item)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding=ListMealBinding.inflate(layoutInflater,parent,false)
        return MealViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(list[position])
    }
}