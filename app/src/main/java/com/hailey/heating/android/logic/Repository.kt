package com.hailey.heating.android.logic

import androidx.lifecycle.liveData
import com.hailey.heating.android.logic.dao.PlaceDao
import com.hailey.heating.android.logic.model.Place
import com.hailey.heating.android.logic.model.Weather
import com.hailey.heating.android.logic.network.HeatingNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

/**
 * get the response data from api and return it
 * Author: Hailey
 */
object Repository {

    /**
     * search place(user input)
     */
    fun searchPlaces(query: String) = fire(Dispatchers.IO) {
        val placeResponse = HeatingNetwork.searchPlaces(query)
        if (placeResponse.status == "ok") {
            val places = placeResponse.places
            Result.success(places)
        } else {
            Result.failure(RuntimeException("response status is not ok"))
        }
    }

fun refreshWeather(lng: String, lat: String) = fire(Dispatchers.IO) {
    coroutineScope {
        // concurrent
        val deferredRealtime = async {
            HeatingNetwork.getRealtimeWeather(lng, lat)
        }
        val deferredDaily = async {
            HeatingNetwork.getDetailWeather(lng, lat)
        }

        // wait until deferred finish
        val realtimeResponse = deferredRealtime.await()
        val dailyResponse = deferredDaily.await()

        // status is ok -> get weather
        if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
            val weather = Weather(realtimeResponse.result.realtime, dailyResponse.result.daily)
            Result.success(weather)
        } else {
            Result.failure(
                RuntimeException(
                    "realtime response status is ${realtimeResponse.status}" +
                            "daily response status is ${dailyResponse.status}"
                )
            )
        }
    }
}

private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
    liveData<Result<T>>(context) {
        val result = try {
            block()
        } catch (e: Exception) {
            Result.failure<T>(e)
        }
        emit(result)
    }


fun savePlace(place: Place) = PlaceDao.savePlace(place)

fun getSavePlace() = PlaceDao.getSavedPlace()

fun isPlaceSave() = PlaceDao.isPlaceSaved()
}
