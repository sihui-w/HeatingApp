package com.hailey.heating.android.ui.place

import androidx.lifecycle.*
import com.hailey.heating.android.logic.Repository
import com.hailey.heating.android.logic.model.Place
import com.hailey.heating.android.logic.model.PlaceResponse

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavePlace(): Place = Repository.getSavePlace()

    fun isPlaceSaved() = Repository.isPlaceSave()


}