package com.example.contactsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.contactsapp.R
import com.example.contactsapp.dao.ContactDb
import com.example.contactsapp.dao.ContactsDao
import com.example.contactsapp.databinding.FragmentEditContactBinding
import com.example.contactsapp.model.Address
import com.example.contactsapp.model.Contact
import com.example.contactsapp.viewmodel.MainViewModel

@ExperimentalStdlibApi
class EditContactFragment : Fragment() {

    lateinit var binding: FragmentEditContactBinding
    val viewModel: MainViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )= FragmentEditContactBinding.inflate(layoutInflater, container, false).also {
        binding = it
    }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            val address = Address(binding.etAddress.text.toString(), "", "", 10000)
            val phoneNumbers = binding.etPhoneNumber.text.toString()
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val emails : ArrayList<String> = arrayListOf()
            emails.add("email")
            val contact = Contact(firstName, lastName, address, phoneNumbers, emails)
            viewModel.insertContact(binding.root.context, contact)
            Navigation.findNavController(view).navigate(R.id.action_editContactFragment_to_contactsFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            EditContactFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}