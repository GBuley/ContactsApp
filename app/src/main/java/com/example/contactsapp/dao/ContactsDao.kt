package com.example.contactsapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contactsapp.model.Contact

@Dao
interface ContactsDao {

    @Query("SELECT * FROM contact WHERE contact_id = :id LIMIT 1")
    suspend fun findContactById(id: Long): Contact?

    @Query("SELECT * FROM contact WHERE fName = :name OR lName = :name")
    suspend fun findContactByName(name:String): Contact?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact:Contact): Long

    @get:Query("SELECT * FROM contact")
    val getAll: List<Contact>
}