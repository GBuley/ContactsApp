package com.example.contactsapp.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Address(
    var city:String,
    val streetAddress:String,
    val state:String,
    val zipcode: Long
):Parcelable
