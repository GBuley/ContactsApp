package com.example.contactsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.databinding.ItemContactBinding
import com.example.contactsapp.model.Contact

class ContactsAdapter(private var contacts : List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {
    class ContactViewHolder(private var binding:ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        fun load(contact: Contact) {
            val initials:String = contact.fName[0].toString() + contact.lName[0].toString()
            binding.tvContactInitials.text = initials
            val firstLast = contact.fName + contact.lName
            binding.nameText.text = firstLast
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding:ItemContactBinding = ItemContactBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.load(contacts.get(position))
    }
}