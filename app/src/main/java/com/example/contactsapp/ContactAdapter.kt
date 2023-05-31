package com.example.contactsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contactsapp.databinding.ContactsListItemBinding

class ContactAdapter(var contactList: List<ContactData>):RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList.get(position)
        val binding = holder.binding
        binding.tvDisplayName.text = currentContact.displayName
        binding.tvPhoneNumber.text = currentContact.phoneNUmber
        binding.tvEmail.text = currentContact.email
        binding.ivImage.setImageResource(currentContact.imageResId)


    }

    override fun getItemCount(): Int {
        return contactList.size

    }

class ContactViewHolder(var binding:ContactsListItemBinding):RecyclerView.ViewHolder(binding.root)}

