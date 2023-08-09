package com.mostafa.foodappf.data.model
import com.google.gson.annotations.SerializedName

data class Categories (
    @SerializedName("categories")
    val  categories:ArrayList<Category>){
    data class Category(
        val idCategory: String,
        @SerializedName("strCategory")
        val strCategory: String,
        @SerializedName("strCategoryDescription")
        val strCategoryDescription: String,
        @SerializedName("strCategoryThumb")
        val strCategoryThumb:  String
    )


}
