package com.myanmaritc.typicoderetrofit2.model1

import com.google.gson.annotations.SerializedName

data class HospitalsItem(

	@field:SerializedName("hospital")
	val hospital: Hospital? = null
)

data class Hospital(

	@field:SerializedName("website_link")
	val websiteLink: String? = null,

	@field:SerializedName("phone_no")
	val phoneNo: String? = null,

	@field:SerializedName("hospital_image")
	val hospitalImage: String? = null,

	@field:SerializedName("facebook_link")
	val facebookLink: String? = null,

	@field:SerializedName("hospital_banner")
	val hospitalBanner: String? = null,

	@field:SerializedName("place")
	val place: String? = null,

	@field:SerializedName("hospital_id")
	val hospitalId: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("specialities")
	val specialities: List<Any?>? = null,

	@field:SerializedName("hospital_name")
	val hospitalName: String? = null
)
