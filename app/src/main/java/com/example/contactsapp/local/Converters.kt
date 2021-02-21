package com.example.contactsapp.local

import androidx.room.TypeConverter
import com.example.contactsapp.model.Address
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

@ExperimentalStdlibApi
class Converters {

    @TypeConverter
    fun addressToString(address:Address):String {
        val adapter = Moshi.Builder().build().adapter<Address>()
        return adapter.toJson(address)

    }

    @TypeConverter
    fun stringToAddress(address:String):Address?{
        val adapter = Moshi.Builder().build().adapter<Address>()
        return adapter.fromJson(address)?:Address("", "", "", 12345)
    }

}