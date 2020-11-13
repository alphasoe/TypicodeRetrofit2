package com.myanmaritc.typicoderetrofit2.api

import com.myanmaritc.typicoderetrofit2.model.City
import com.myanmaritc.typicoderetrofit2.model.Hospital
import com.myanmaritc.typicoderetrofit2.model.HospitalsItem
import retrofit2.Call
import retrofit2.http.*

interface HospitalApiInterface {
    @GET("hospital")

    fun getAllHospital(): Call<Hospital>

    @GET("hospital/{id}")

    fun getDetails(
        @Path("id") id: String
    ): Call<com.myanmaritc.typicoderetrofit2.model1.HospitalsItem>

    @FormUrlEncoded
    @POST("setup/city")
    fun addCity(
        @Field("city_name") cityName: String
    ): Call<City>
}