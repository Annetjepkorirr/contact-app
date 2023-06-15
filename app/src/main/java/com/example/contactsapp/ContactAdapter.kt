package com.example.contactsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contactsapp.databinding.ContactsListItemBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactAdapter(var contactList: List<ContactData>):RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

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
        binding.tvPhoneNumber.text = currentContact.phoneNUmber
        binding.tvEmail.text = currentContact.email
        Picasso
            .get()
            .load(currentContact.image)
            .resize(80,80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivImage)

//        binding.ivImage.setImageResource(currentContact.image)


    }

    override fun getItemCount(): Int {
        return contactList.size

    }

class ContactViewHolder(var binding:ContactsListItemBinding):RecyclerView.ViewHolder(binding.root)}

