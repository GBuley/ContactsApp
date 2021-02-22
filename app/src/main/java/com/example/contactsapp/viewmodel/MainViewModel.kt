package com.example.contactsapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.dao.ContactDb
import com.example.contactsapp.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@ExperimentalStdlibApi
class MainViewModel(application: Application) : AndroidViewModel(application){

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts :LiveData<List<Contact>> = _contacts

    private val _contact = MutableLiveData<Contact>()
    val contact :LiveData<Contact> = _contact


    fun insertContact(context: Context, contact:Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            val contactDao = ContactDb.getDatabase(context)?.contactDao()
            contactDao?.insert(contact)
        }

    }

    fun getContactById(context: Context, id:Long){
        viewModelScope.launch(Dispatchers.IO) {
            val contact = ContactDb.getDatabase(context)?.contactDao()?.findContactById(id)
            _contact.postValue(contact!!)
        }
    }
    fun getContactByName(context: Context, name:String){
        viewModelScope.launch(Dispatchers.IO) {
            val contactDao = ContactDb.getDatabase(context)?.contactDao()
            contactDao?.findContactByName(name)
        }
    }
    fun getContacts(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            val contactDao = ContactDb.getDatabase(context)?.contactDao()
            _contacts.postValue(contactDao?.getAll)
        }
    }

    fun updateContact(context: Context, contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            val contactDao = ContactDb.getDatabase(context)?.contactDao()
            Log.i("TAG", contact.id.toString())
            contactDao?.updateContact(contact)
            _contacts.postValue(contactDao?.getAll)
        }
    }

}
