package com.hailey.heating.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * define the responsed data
 * Author: Hailey
 */


    /**
     * details of the place
     */

class PlaceResponse(val status: String, val places: List<Place>)

class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)

class Location(val lng: String, val lat: String)