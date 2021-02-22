package com.example.contactsapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.contactsapp.local.Converters
import com.example.contactsapp.model.Contact
import java.security.AccessControlContext

@ExperimentalStdlibApi
@TypeConverters(Converters::class)
@Database(entities = [Contact::class], version = 1)
abstract class ContactDb : RoomDatabase(){
    abstract fun contactDao():ContactsDao

    companion object {
        private const val DB_NAME = "ContactDb.db"
        private var INSTANCE:ContactDb? = null

        fun getDatabase(context: Context): ContactDb? {
            if (INSTANCE == null)
                synchronized(ContactDb::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ContactDb::class.java,
                            DB_NAME
                        )
                            .fallbackToDestructiveMigration().build()
                    }
                }
            return INSTANCE

        }
    }
}