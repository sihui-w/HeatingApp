package com.hailey.heating.android.logic.network

import com.hailey.heating.android.HeatingApplication
import com.hailey.heating.android.logic.model.DailyResponse
import com.hailey.heating.android.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${HeatingApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng")lng: String, @Path("lat")lat:String): Call<RealtimeResponse>

    @GET("v2.6/${HeatingApplication.TOKEN}/{lng},{lat}/daily?dailysteps=5&lang=en_US")
    fun getDailyWeather(@Path("lng")lng: String, @Path("lat")lat: String): Call<DailyResponse>

}