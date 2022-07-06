package com.hailey.heating.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.hailey.heating.android.HeatingApplication
import com.hailey.heating.android.logic.model.Place

object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        HeatingApplication.context.getSharedPreferences("heating", Context.MODE_PRIVATE)

}