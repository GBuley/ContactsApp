package com.example.contactsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavAction
import androidx.navigation.NavArgs
import androidx.navigation.NavArgument
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp.R
import com.example.contactsapp.adapter.ContactsAdapter
import com.example.contactsapp.databinding.FragmentContactsBinding
import com.example.contactsapp.viewmodel.MainViewModel

@ExperimentalStdlibApi
class ContactsFragment : Fragment() {
    lateinit var binding:FragmentContactsBinding
    val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )= FragmentContactsBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getContacts(binding.root.context)
        viewModel.contacts.observe(viewLifecycleOwner, Observer { contacts ->
            val adapter = ContactsAdapter(contacts)
            val layoutManager = LinearLayoutManager(binding.root.context)
            binding.rvContacts.layoutManager = layoutManager
            binding.rvContacts.adapter = adapter
        })
        binding.btnAddContact.setOnClickListener {
//            val args = EditContactFragmentArgs.fromBundle()
            Navigation.findNavController(view).navigate(R.id.action_contactsFragment_to_editContactFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ContactsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}