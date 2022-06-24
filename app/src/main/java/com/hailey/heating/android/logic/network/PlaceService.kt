package com.hailey.heating.android.logic.network

import com.hailey.heating.android.HeatingApplication
import com.hailey.heating.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

    interface PlaceService {
        @GET("v2/place?token=${HeatingApplication.TOKEN}&lang=zh_CN")
        fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
    }
