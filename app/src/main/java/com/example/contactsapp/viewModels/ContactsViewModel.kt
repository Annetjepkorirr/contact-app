package com.example.contactsapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.models.ContactData
import com.example.contactsapp.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    val contactRepo = ContactsRepository()
    lateinit var contactLiveData: LiveData<ContactData>

    fun saveContact(contact: ContactData) {
        viewModelScope.launch {
            contactRepo.saveContact(contact)

        }
    }
        fun getDbContacts(): LiveData<List<ContactData>>{
            return contactRepo.getDbContacts()
        }
    fun getContactById(contactId:Int):LiveData<ContactData>{
        return contactRepo.getContactById(contactId)
    }
    }


