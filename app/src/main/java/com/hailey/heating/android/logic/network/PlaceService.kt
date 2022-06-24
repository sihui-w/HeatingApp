package com.hailey.heating.android.logic.network

import com.hailey.heating.android.HeatingApplication
import com.hailey.heating.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("data/3.0/onecall?exclude=minutely&appid=${HeatingApplication.TOKEN}")
    fun searchPlace(@Query("lat") lat: String, @Query("lon") lon: String): Call<PlaceResponse>
}