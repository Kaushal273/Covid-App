package com.example.covidapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("covid19-in/stats/latest")
    fun getStats() : Call<MutableList<InfoModel>>
}