package com.myanmaritc.typicoderetrofit2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myanmaritc.typicoderetrofit2.R
import com.myanmaritc.typicoderetrofit2.api.ApiClient
import com.myanmaritc.typicoderetrofit2.model.City
import kotlinx.android.synthetic.main.fragment_add_city.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var apiClient = ApiClient()

        btnAdd.setOnClickListener {
            var cityName = editCity.text.toString()
            var apiCall = apiClient.addCity(cityName)

            apiCall.enqueue(object : Callback<City> {
                override fun onFailure(call: Call<City>, t: Throwable) {
                    txtStatus.text = t.toString()
                }

                override fun onResponse(call: Call<City>, response: Response<City>) {
                    txtStatus.text = response.body()?.message
                }

            })
        }
    }
}