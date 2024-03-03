package com.example.aston_intensiv_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aston_intensiv_3.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {

    private val viewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAddContactBinding.inflate(inflater)
        binding.confirmButton.setOnClickListener{
            viewModel.addContact(
                binding.addNameEditText.text.toString(),
                binding.addLastnameEditText.text.toString(),
                binding.addNumberEditText.text.toString()
            )

            Toast.makeText(context, "contact added ${viewModel.contactsList.value?.size}", LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addContactFragment_to_contactListFragment)
        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addContactFragment_to_contactListFragment)
        }

        return binding.root
    }
}