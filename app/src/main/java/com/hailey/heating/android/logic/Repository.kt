package com.hailey.heating.android.logic

import androidx.lifecycle.liveData
import com.hailey.heating.android.logic.dao.PlaceDao
import com.hailey.heating.android.logic.model.Place
import com.hailey.heating.android.logic.model.PlaceResponse
import com.hailey.heating.android.logic.network.HeatingNetwork
import kotlinx.coroutines.Dispatchers

/**
 * get the response data from api and return it
 * Author: Hailey
 */
object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = HeatingNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is not ok"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }

    fun savePlace(place: Place) = PlaceDao.savePlace(place)

    fun getSavePlace() = PlaceDao.getSavedPlace()

    fun isPlaceSave() = PlaceDao.isPlaceSaved()
}
