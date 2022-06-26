package com.hailey.heating.android.logic.model

/**
 * weather detail
 * Author: Hailey
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)