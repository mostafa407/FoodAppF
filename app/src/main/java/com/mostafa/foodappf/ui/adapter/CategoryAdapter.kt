package com.mostafa.foodappf.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mostafa.foodappf.data.model.Categories
import com.mostafa.foodappf.databinding.ListItemBinding

class CategoryAdapter(var  list:ArrayList<Categories.Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
  var onListItemClick:OnListItemClick?=null
    inner  class CategoryViewHolder(val listItemBinding: ListItemBinding):
      RecyclerView.ViewHolder(listItemBinding.root) {
      fun bind(item: Categories.Category) {

          listItemBinding.model = item
          Glide.with(itemView.context).asBitmap().load(item.strCategoryThumb)
              .into(listItemBinding.strCategoryThumb)
          listItemBinding.strCategory.text = item.strCategory
          itemView.setOnClickListener {
              onListItemClick?.onItem(item)
          }

      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding)

    }

    override fun getItemCount(): Int {
        Log.d("COUNT", ".getItemCountcalled ${list.size}")

        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
    }
}