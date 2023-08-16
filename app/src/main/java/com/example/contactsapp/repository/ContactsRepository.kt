package com.example.contactsapp.repository

import androidx.lifecycle.LiveData
import com.example.contactsapp.ContactsApp
import com.example.contactsapp.database.ContactsDb
import com.example.contactsapp.models.ContactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//access the database

class ContactsRepository {
    val database = ContactsDb.getDatabase(ContactsApp.appContext)

    suspend fun saveContact(contactData: ContactData){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contactData)
        }
    }
    fun getDbContacts(): LiveData<List<ContactData>>{
        return database.contactDao().getAllContacts()
    }

    fun getContactById(contactId:Int):LiveData<ContactData>{
        return database.contactDao().getContactById(contactId)
    }
}