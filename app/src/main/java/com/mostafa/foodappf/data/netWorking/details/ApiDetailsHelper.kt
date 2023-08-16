package com.mostafa.foodappf.data.netWorking.details

class ApiDetailsHelper(private val apiDetails: ApiDetails) {
    suspend fun getDetail( i:Int)=apiDetails.getDetail(i)
}