package com.example.aston_intensiv_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.aston_intensiv_3.databinding.FragmentContactListBinding
import com.example.aston_intensiv_3.recycler.ContactAdapter

class ContactListFragment : Fragment() {

    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactListBinding.inflate(inflater)
        val adapter = ContactAdapter {
            val action =
                ContactListFragmentDirections.actionContactListFragmentToUpdateContactFragment(it.id)
            findNavController().navigate(action)
        }

        val contacts = viewModel.contactsList
        adapter.submitList(contacts.value)
        binding.recyclerView.adapter = adapter
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_contactListFragment_to_addContactFragment2)
        }

        binding.fab.setOnClickListener {
            viewModel.changeDeleteMode()
            changeButtons()
        }
        return binding.root
    }

    private fun changeButtons() {
        if (viewModel.isDeleteMode) {
            binding.deleteButton.visibility = View.VISIBLE
            binding.cancelButton.visibility = View.VISIBLE
            binding.addButton.visibility = View.INVISIBLE
        } else {
            binding.deleteButton.visibility = View.GONE
            binding.cancelButton.visibility = View.GONE
            binding.addButton.visibility = View.VISIBLE
        }
    }
}