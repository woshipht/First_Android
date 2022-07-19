package com.example.firstAndroid.Retrofit

import retrofit2.Call
import retrofit2.http.GET

interface informationService {

    @GET("information.json")
    fun getInformationData(): Call<List<information>>
}