package com.myanmaritc.typicoderetrofit2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myanmaritc.typicoderetrofit2.api.ApiClient
import com.myanmaritc.typicoderetrofit2.model.Hospital
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalViewModel : ViewModel() {
    private var hospital: MutableLiveData<Hospital> = MutableLiveData()

    fun getHospital() = hospital

    fun loadHospital() {
        val apiClient = ApiClient()
        val apiCall = apiClient.getAllHospital()

        apiCall.enqueue(object : Callback<Hospital> {
            override fun onFailure(call: Call<Hospital>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Hospital>, response: Response<Hospital>) {
                hospital.value = response.body()
            }

        })
    }
}