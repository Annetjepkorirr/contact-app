package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        displayContacts()
    }

    fun displayContacts() {
        val contact1 = ContactData(
            "Annette",
            "0735415618",
            "annette@gmail.com",
            imageResId = R.drawable.image1
        )
        val contact2 =
            ContactData("Lynet", "4563747456", "linet@gmail.com", imageResId = R.drawable.image1)
        val contact3 = ContactData(
            "Eucabeth",
            "3286498574",
            "eucabeth@gmail.com",
            imageResId = R.drawable.image1
        )
        val contact4 = ContactData(
            "Abigael",
            "3657628395",
            "abigael2gmail.com",
            imageResId = R.drawable.image1
        )
        val contactList = listOf(contact1, contact2, contact3, contact4)
        val contactAdapter = ContactAdapter(contactList)
        binding.tvcontacts.layoutManager = LinearLayoutManager(this)
        binding.tvcontacts.adapter = contactAdapter

    }
}



