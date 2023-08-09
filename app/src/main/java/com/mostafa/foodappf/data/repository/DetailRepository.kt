package com.mostafa.foodappf.data.repository

import com.mostafa.foodappf.data.netWorking.details.ApiDetailsHelper

class DetailRepository(private val apiDetailsHelper: ApiDetailsHelper) {
    suspend fun getDetail()=apiDetailsHelper.getDetail()
}