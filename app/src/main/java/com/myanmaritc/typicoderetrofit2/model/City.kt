package com.myanmaritc.typicoderetrofit2.model

import com.google.gson.annotations.SerializedName

data class City(

	@field:SerializedName("city")
	val city: City? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("city_name")
	val cityName: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
