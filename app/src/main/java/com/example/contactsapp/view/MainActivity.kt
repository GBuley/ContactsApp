package com.example.contactsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contactsapp.databinding.ActivityMainBinding
import com.example.contactsapp.viewmodel.MainViewModel


@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>(){
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        viewModel.getContacts(binding.root.context)
        viewModel.contacts.observe(this, Observer { contacts ->

//            Log.i("TAG", contacts.get(0).fName)
        })

    }

}