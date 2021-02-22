package com.example.contactsapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(
    tableName = "contact"
)
@kotlinx.android.parcel.Parcelize
@JsonClass(generateAdapter = true)
data class Contact(
        val fName:String,
        val lName:String,
        val address:Address,
        val phoneNumbers: String,
        val emails:List<String>
):Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="contact_id") var id: Long = 0
}