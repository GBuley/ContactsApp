package com.example.contactsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactsapp.R

class MainActivity : AppCompatActivity(), ContactsFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun goToEditFragment() {
        TODO("Not yet implemented")
    }

    override fun goToDetailsFragment() {
        TODO("Not yet implemented")
    }
}