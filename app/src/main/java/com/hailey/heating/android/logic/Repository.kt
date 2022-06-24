package com.hailey.heating.android.logic

import androidx.lifecycle.liveData
import com.hailey.heating.android.logic.model.PlaceResponse
import com.hailey.heating.android.logic.network.HeatingNetwork
import kotlinx.coroutines.Dispatchers

/**
 * get the response data from api and return it
 * Author: Hailey
 */
object Repository {
    fun searchPlaces(lat: String, lon: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = HeatingNetwork.searchPlaces(lat, lon)
            if (placeResponse.lat.isNotBlank()) {
                val places = placeResponse.lat
                Result.success(places)
            } else {
                Result.failure(RuntimeException("No response"))
            }
        } catch (e: Exception) {
            Result.failure<List<PlaceResponse>>(e)
        }
        emit(result)
    }
}
