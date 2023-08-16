package com.example.contactsapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.models.ContactData
import com.example.contactsapp.databinding.ContactsListItemBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactAdapter(var contactList: List<ContactData>, val context: Context):RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    //inflate binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList.get(position)
        val binding = holder.binding
        binding.tvDisplayName.text = currentContact.displayName
        binding.tvPhoneNumber.text = currentContact.phoneNumber
        binding.tvEmail.text = currentContact.email
        if (currentContact.image.isNotBlank()) {
            Picasso
                .get()
                .load(currentContact.image)
                .resize(80, 80)
                .centerInside()
                .transform(CropCircleTransformation())
                .into(binding.ivImage)

//        binding.ivImage.setImageResource(currentContact.image)
        }
        binding.cvContact.setOnClickListener{
            val intent = Intent(context,ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID", currentContact.contactId)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return contactList.size

    }

class ContactViewHolder(var binding:ContactsListItemBinding):RecyclerView.ViewHolder(binding.root)}

