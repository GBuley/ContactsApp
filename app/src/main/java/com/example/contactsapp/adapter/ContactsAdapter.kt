package com.example.contactsapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.R
import com.example.contactsapp.databinding.ItemContact2Binding
import com.example.contactsapp.databinding.ItemContactBinding
import com.example.contactsapp.model.Contact
import com.example.contactsapp.view.ContactsFragmentDirections
import com.example.contactsapp.view.EditContactFragmentArgs

class ContactsAdapter(private var contacts : List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {
    class ContactViewHolder(private var binding:ItemContact2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun load(contact: Contact) {
            val initials:String = contact.fName[0].toString() + contact.lName[0].toString()
            binding.tvContactInitials.text = initials
            val firstLast = contact.fName + contact.lName
            binding.nameText.text = firstLast
            binding.nameText.setOnClickListener {
                val action = ContactsFragmentDirections.actionContactsFragmentToDetailsFragment(contact)
                Navigation.findNavController(binding.root).navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContact2Binding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.load(contacts.get(position))
    }
}