package com.example.contactsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import android.widget.Toast
import androidx.activity.viewModels
import com.example.contactsapp.databinding.ActivityAddContactsBinding
import com.example.contactsapp.models.ContactData
import com.example.contactsapp.viewModels.ContactsViewModel

class AddContacts : AppCompatActivity() {
    lateinit var binding: ActivityAddContactsBinding
    private val contactsViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            validateAddContact()
        }
    }

    fun validateAddContact(){
        val name1 = binding.etfirstName.text.toString()
        val name2= binding.etsecondName.text.toString()
        val phone = binding.etphoneNumber.text.toString()
        val email = binding.etemail.text.toString()

        var error =false

        if (name1.isEmpty()) {
            binding.tvfirstName.error = "First Namerequired"
            Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show();
            error = true
       }


        if (name2.isEmpty()){
            binding.tvsecondName.error= "SecondName required"
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show()
            error = true
        }

        if (phone.isEmpty()) {
            binding.tvphoneNumber.error = "Password required"
            Toast.makeText(this, "Please enter last name", Toast.LENGTH_SHORT).show();
            error = true
        }

        if (email.isEmpty()) {
            binding.tvEmail.error = "Password required"
            Toast.makeText(this, "Please enter last name", Toast.LENGTH_SHORT).show();
            error = true
        }

        if (!error){
            val newContact = ContactData(contactId = 0, displayName = "$name1 $name2", phoneNumber = phone, email = email, image = "")
            contactsViewModel.saveContact(newContact)
            Toast.makeText(this,"Contact added", Toast.LENGTH_SHORT).show()
            finish()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }


}




