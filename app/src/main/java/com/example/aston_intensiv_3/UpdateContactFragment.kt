package com.example.aston_intensiv_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.aston_intensiv_3.databinding.FragmentUpdateContactBinding

class UpdateContactFragment : Fragment() {

    private val viewModel: ContactViewModel by activityViewModels()

    private val navigationArgs: UpdateContactFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateContactBinding.inflate(inflater)
        val id = navigationArgs.contactId
        val currentContact = viewModel.contactsList.value?.find { it.id == id }
        binding.updateNameEditText.setText(currentContact?.name)
        binding.updateLastnameEditText.setText(currentContact?.lastName)
        binding.updateNumberEditText.setText(currentContact?.number)
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_updateContactFragment_to_contactListFragment)
        }
        binding.updateButton.setOnClickListener {
            viewModel.updateContact(
                id,
                binding.updateNameEditText.text.toString(),
                binding.updateLastnameEditText.text.toString(),
                binding.updateNumberEditText.text.toString()
                )
            Toast.makeText(context, "Contact updated", LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateContactFragment_to_contactListFragment)
        }

        return binding.root
    }

}