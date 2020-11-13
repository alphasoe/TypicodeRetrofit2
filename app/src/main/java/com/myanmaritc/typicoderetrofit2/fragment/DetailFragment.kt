package com.myanmaritc.typicoderetrofit2.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.myanmaritc.typicoderetrofit2.R
import com.myanmaritc.typicoderetrofit2.api.ApiClient
import com.myanmaritc.typicoderetrofit2.model.HospitalsItem
import com.myanmaritc.typicoderetrofit2.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {
    lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        var messageArgs = arguments?.let {
            DetailFragmentArgs.fromBundle(it)
        }

        var message: String = messageArgs?.id.toString()

        val apiClient = ApiClient()

        val apiCall = apiClient.getDetail(message)

        apiCall.enqueue(object :Callback<com.myanmaritc.typicoderetrofit2.model1.HospitalsItem>{
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
                address_txtView.text=response.body().toString()
            }

        })



        phno_txtView.text = message
       // address_txtView.text = detailViewModel.loadDetail().place
    }

}