package com.myanmaritc.typicoderetrofit2.api

import com.myanmaritc.typicoderetrofit2.model.City
import com.myanmaritc.typicoderetrofit2.model.Hospital
import com.myanmaritc.typicoderetrofit2.model.HospitalsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "http://hospitalguideapi.dsv.hoz.mybluehost.me/api/"

   // private val BASE_URL = "https://food-delivery-api.chaneihmwe.com/api/"

    private val apiInterface: HospitalApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(
            HospitalApiInterface::class.java
        )
    }

    fun getAllHospital(): Call<Hospital> {
        return apiInterface.getAllHospital()
    }

    fun getDetail(id: String): Call<com.myanmaritc.typicoderetrofit2.model1.HospitalsItem> {
        return apiInterface.getDetails(id)
    }

    fun addCity(cityName: String): Call<City> {
        return apiInterface.addCity(cityName)
    }
}