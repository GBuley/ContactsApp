package com.example.contactsapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "contact"
)
@kotlinx.android.parcel.Parcelize
data class Contact(
    val fName:String,
    val lName:String,
    val address:Address,
    val phoneNumber:List<String>,
    val email:List<String>
):Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="contact_id") val id: Long = 0
}