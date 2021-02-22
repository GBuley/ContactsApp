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
    val phoneNumbers:List<String>,
    val emails:List<String>
):Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="contact_id") var id: Long = 0
}