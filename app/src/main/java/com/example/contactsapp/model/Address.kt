package com.example.contactsapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    val city:String,
    val streetAddress:String,
    val state:String,
    val zipcode: Long
):Parcelable
