package com.example.contactsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentEditContactBinding
import com.example.contactsapp.model.Address
import com.example.contactsapp.model.Contact
import com.example.contactsapp.viewmodel.MainViewModel

@ExperimentalStdlibApi
class EditContactFragment : Fragment() {
    val args: EditContactFragmentArgs by navArgs()

    lateinit var binding: FragmentEditContactBinding
    val viewModel: MainViewModel by activityViewModels()
    var flag = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentEditContactBinding.inflate(layoutInflater, container, false).also {
        binding = it
    }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.contact != null) {
            binding.etAddress.setText(args.contact!!.address.city)
            binding.etFirstName.setText(args.contact!!.fName)
            binding.etLastName.setText(args.contact!!.lName)
            binding.etPhoneNumber.setText(args.contact!!.phoneNumbers)
            flag = true
        }

        binding.btnSubmit.setOnClickListener {
            args.contact?.let { editedContact ->
                editedContact.fName = binding.etFirstName.text.toString()
                editedContact.lName = binding.etLastName.text.toString()
                editedContact.phoneNumbers = binding.etPhoneNumber.text.toString()
                editedContact.address = Address(binding.etAddress.text.toString(), "", "", 10000)
                viewModel.updateContact(binding.root.context, editedContact)
            } ?: kotlin.run {
                val address = Address(binding.etAddress.text.toString(), "","",10000)
                val emails : ArrayList<String> = arrayListOf()
                emails.add("email")
                val contact = Contact(binding.etFirstName.text.toString(),binding.etLastName.text.toString(),  address, binding.etPhoneNumber.text.toString(), emails)
                viewModel.insertContact(binding.root.context, contact)
            }
            Navigation.findNavController(view)
                .navigate(R.id.action_editContactFragment_to_contactsFragment)
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