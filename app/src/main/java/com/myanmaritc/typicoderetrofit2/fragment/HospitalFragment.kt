package com.myanmaritc.typicoderetrofit2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myanmaritc.typicoderetrofit2.R
import com.myanmaritc.typicoderetrofit2.fragment.adapter.HospitalAdapter
import com.myanmaritc.typicoderetrofit2.model.HospitalsItem
import com.myanmaritc.typicoderetrofit2.viewmodel.HospitalViewModel
import kotlinx.android.synthetic.main.fragment_hospital.*


class HospitalFragment : Fragment(), HospitalAdapter.ClickListener {

    lateinit var hospitalViewmodel: HospitalViewModel
    lateinit var hospitalAdapter: HospitalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hospitalViewmodel = ViewModelProvider(this).get(HospitalViewModel::class.java)

        hospitalAdapter = HospitalAdapter()

        hospitalAdapter.setOnClickListener(this)

        recyclerHospital.layoutManager = LinearLayoutManager(context)
        recyclerHospital.adapter = hospitalAdapter


        hospitalViewmodel.getHospital().observe(
            viewLifecycleOwner,
            Observer { hospitalAdapter.updateHospital(it.hospitals as List<HospitalsItem>) }
        )


    }

    override fun onClick(hospitalsItem: HospitalsItem) {
        var hospitalId = hospitalsItem.hospitalId
        var action =
            HospitalFragmentDirections.actionHospitalFragmentToDetailFragment(hospitalId.toString())

        findNavController().navigate(action)
    }


    override fun onResume() {
        super.onResume()
        hospitalViewmodel.loadHospital()
    }

}
