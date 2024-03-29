package com.example.contactsapp.database

import android.content.Context
import android.provider.ContactsContract.Contacts
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsapp.models.ContactData

@Database(entities = [ContactData::class], version = 1)
abstract class ContactsDb:RoomDatabase() {
    abstract fun contactDao():ContactDao

    companion object{
        private var database:ContactsDb? = null

        fun getDatabase(context:Context):ContactsDb{
            if (database == null){
                database =Room
                    .databaseBuilder(context,ContactsDb::class.java,"ContactDb")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as ContactsDb
        }
    }
}