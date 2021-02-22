package com.example.contactsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    val args: DetailsFragmentArgs by navArgs()
    lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailsBinding.inflate(layoutInflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDetailsFirstName.text = args.contact.fName
        binding.tvDetailsLastName.text = args.contact.lName
        binding.tvDetailsPhoneNumber.text = args.contact.phoneNumbers
        binding.tvDetailsAddress.text = args.contact.address.city
        binding.tvContactInitials.text = args.contact.fName[0].toString() + args.contact.lName[0].toString()
        binding.btnUpdate.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToEditContactFragment(args.contact)
            Navigation.findNavController(binding.root).navigate(action)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}