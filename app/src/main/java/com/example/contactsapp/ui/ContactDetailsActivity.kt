package com.example.contactsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.contactsapp.R
import com.example.contactsapp.databinding.ActivityAddContactsBinding
import com.example.contactsapp.databinding.ActivityContactDetailsBinding
import com.example.contactsapp.models.ContactData
import com.example.contactsapp.viewModels.ContactsViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactDetailsBinding
    private lateinit var viewModel: ContactsViewModel
    var contactid =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ContactsViewModel()

        val contactId = intent.getIntExtra("CONTACT_ID", 0)

        viewModel.getContactById(contactId).observe(this, Observer{ bundle ->
            if (bundle != null) {
                displayContactDetails(bundle)
            } else {
                Toast.makeText(this, "Contact not found", Toast.LENGTH_SHORT).show()
            }
        })

    }
        private fun displayContactDetails(contact:ContactData) {
        binding.tvName.text = contact.displayName
        binding.tvPhoneNumbers.text = contact.phoneNumber
        binding.tvmail.text = contact.email
        if (!contact.image.isNullOrEmpty()) {
            Picasso
                .get()
                .load(contact.image)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.ivAvatar)
        }
    }
}



