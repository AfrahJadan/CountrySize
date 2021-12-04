package com.example.android.countriesphotos.network

import com.squareup.moshi.Json


data class ImageResponseModel(val error:Boolean, val msg:String, val data:List<CountriesImage>)
data class CountriesImage (@Json(name="name")
    val name:String, @Json(name ="flag")val flag:String)