package com.hailey.heating.android.ui.place

import androidx.lifecycle.*
import com.hailey.heating.android.logic.Repository
import com.hailey.heating.android.logic.model.PlaceResponse

class PlaceViewModel : ViewModel() {

    private val lat  = MutableLiveData<String>()
    private val lon  = MutableLiveData<String>()

    private val searchLiveData = MediatorLiveData<Pair<String?, String?>>().apply {
        addSource(lat) {
            value = Pair(it, lon.value)
        }
        addSource(lon) {
            value = Pair(lat.value, it)
        }
    }

    val placeList = ArrayList<PlaceResponse>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { pair ->
        pair.first?.let { pair.second?.let { it1 -> Repository.searchPlaces(it, it1) } }
    }

    fun searchPlaces(pair : Pair<MutableLiveData<String>, MutableLiveData<String>>){
        val first = pair.first
        val second = pair.second

        val searchLiveData = MediatorLiveData<Pair<String?, String?>>().apply {
            addSource(first) {
                value = Pair(it, second.value)
            }
            addSource(second) {
                value = Pair(first.value, it)
            }
        }

    }


}