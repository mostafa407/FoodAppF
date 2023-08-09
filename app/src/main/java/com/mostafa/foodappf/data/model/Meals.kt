package com.mostafa.foodappf.data.model


import com.google.gson.annotations.SerializedName

data class Meals(
    @SerializedName("meals")
    val meals :ArrayList<Meal>){
data class Meal(
    @SerializedName("idMeal")
    val idMeal: String? = null,
    @SerializedName("strMeal")
    val strMeal: String? = null,
    @SerializedName("strMealThumb")
    val strMealThumb: String? = null
)}