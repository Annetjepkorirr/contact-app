package com.example.contactsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.databinding.ActivityAddContactsBinding
import com.example.contactsapp.databinding.ActivityMainBinding
import com.example.contactsapp.models.ContactData
import com.example.contactsapp.ui.AddContacts
import com.example.contactsapp.ui.ContactAdapter
import com.example.contactsapp.viewModels.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvbtnAdd.setOnClickListener {
            val intent = Intent(this, AddContacts::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
//        displayContacts()
        binding.tvbtnAdd.setOnClickListener {
//            startActivity(this, AddContacts::class.java)
            val tends = Intent(this, AddContacts::class.java)
            startActivity(tends)

        }


        contactViewModel.getDbContacts()
            .observe(this,
                {contactsList -> displayContacts(contactsList)})


    }

    fun displayContacts(contactsList:List<ContactData>) {
        val contactAdapter = ContactAdapter(contactsList, this)  //here we display contacts
        binding.cvContact.layoutManager = LinearLayoutManager(this)
        binding.cvContact.adapter = contactAdapter
//
//        val contact1 = ContactData(
//            0,
//            "",
//            "0735415618",
//            "annette@gmail.com",
//           "https://images.unsplash.com/photo-1604684330644-25c4d8142c01?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=377&q=80",
//
//        )
//        val contact2 =
//            ContactData(0,"Lynet", "4563747456", "linet@gmail.com", image = "https://images.unsplash.com/photo-1602081871114-2bad7b9b6ba8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=415&q=80")
//        val contact3 = ContactData(
//            0,
//            "Eucabeth",
//            "3286498574",
//            "eucabeth@gmail.com",
//            image = "https://images.unsplash.com/photo-1502767882403-636aee14f873?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80"
//        )
//        val contact4 = ContactData(0,
//            "Abigael",
//            "3657628395",
//            "abigael2gmail.com",
//            image = "https://images.unsplash.com/photo-1517598024396-46c53fb391a1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80"
//        )
//
//        val contact5= ContactData(0,
//            "Karen",
//            "588590495",
//            "karenmgmail.com",
//            image = "https://plus.unsplash.com/premium_photo-1661515517471-bbf8b470f422?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=872&q=80"
//        )
//
//        val contact6= ContactData(0,
//            "Dennis",
//            "9809628395",
//            "dennisgmail.com",
//            image = "https://images.unsplash.com/photo-1604684330644-25c4d8142c01?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=377&q=80"
//        )
//
//        val contact7 = ContactData(
//            0,
//            "Samara",
//            "126250395",
//            "samaragmail.com",
//            image = "https://images.unsplash.com/photo-1601821326018-d949a54b6402?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=415&q=80"
//        )
//
//        val contact8 = ContactData(0,
//            "Nathalie",
//            "25435652714",
//            "nathalie77gmail.com",
//            image = "https://images.unsplash.com/photo-1532074205216-d0e1f4b87368?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=441&q=80"
//        )
//
//        val contact9 = ContactData(
//            0,
//            "Elizabeth",
//            "2569628395",
//            "elizabeth12gmail.com",
//            image = "https://images.unsplash.com/photo-1518310952931-b1de897abd40?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=871&q=80"
//        )
//
//        val contact10 = ContactData(
//            0,
//            "Bethuel",
//             "9427628395",
//            "bethuelgmail.com",
//            image = "https://images.unsplash.com/photo-1516585427167-9f4af9627e6c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=580&q=80"
//        )
//
//
//        val contactList = listOf(contact1, contact2, contact3, contact4,contact5,contact6,contact7,contact8,contact9,contact10)


    }
}



