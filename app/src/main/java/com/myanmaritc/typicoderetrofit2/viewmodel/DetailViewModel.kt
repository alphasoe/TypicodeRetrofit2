package com.myanmaritc.typicoderetrofit2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myanmaritc.typicoderetrofit2.api.ApiClient
import com.myanmaritc.typicoderetrofit2.model.Hospital
import com.myanmaritc.typicoderetrofit2.model.HospitalsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private var hospitalDetail:HospitalsItem?=null

    fun loadDetail() = hospitalDetail

    fun getDetail(id: String) {
        val apiClient = ApiClient()

        val apiCall = apiClient.getDetail(id)

        apiCall.enqueue(object : Callback<com.myanmaritc.typicoderetrofit2.model1.HospitalsItem> {
            override fun onFailure(
                call: Call<com.myanmaritc.typicoderetrofit2.model1.HospitalsItem>,
                t: Throwable
            ) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<com.myanmaritc.typicoderetrofit2.model1.HospitalsItem>,
                response: Response<com.myanmaritc.typicoderetrofit2.model1.HospitalsItem>
            ) {
                TODO("Not yet implemented")
            }

        })
    }
}