package com.hailey.heating.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * define the responsed data
 * Author: Hailey
 */


    /**
     * details of the place
     */
    class PlaceResponse(val lat: String, val lon: String,
                             @SerializedName("timezone") val city: String,
                             @SerializedName("timezone_offset") val offset: String)

