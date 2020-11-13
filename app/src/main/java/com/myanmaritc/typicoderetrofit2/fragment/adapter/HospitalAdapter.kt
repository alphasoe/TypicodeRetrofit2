package com.myanmaritc.typicoderetrofit2.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myanmaritc.typicoderetrofit2.R
import com.myanmaritc.typicoderetrofit2.model.HospitalsItem
import kotlinx.android.synthetic.main.item_hospital.view.*

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {
    private var hospitalItems: List<HospitalsItem> = ArrayList()

    var clickListener: ClickListener? = null


    inner class HospitalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var hospitalsItem: HospitalsItem

        fun bind(hospitalsItem: HospitalsItem) {
            this.hospitalsItem = hospitalsItem
            itemView.hospitalName.text = hospitalsItem.hospitalName
        }

        override fun onClick(v: View?) {
            clickListener?.onClick(hospitalsItem)
        }
    }

    fun setOnClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hospital, parent, false)
        return HospitalViewHolder(view)
    }

    override fun getItemCount(): Int = hospitalItems.size

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospitalItems[position])
    }

    fun updateHospital(hospitalList: List<HospitalsItem>) {
        this.hospitalItems = hospitalList
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClick(hospitalsItem: HospitalsItem)
    }
}