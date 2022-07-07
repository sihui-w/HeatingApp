package com.hailey.heating.android.logic.network

import com.hailey.heating.android.HeatingApplication
import com.hailey.heating.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * request: place search
 */
    interface PlaceService {
        @GET("v2/place?token=${HeatingApplication.TOKEN}&lang=en_US")
        fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
    }
