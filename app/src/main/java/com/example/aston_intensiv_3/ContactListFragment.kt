package com.example.aston_intensiv_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.aston_intensiv_3.databinding.FragmentContactListBinding
import com.example.aston_intensiv_3.recycler.ContactAdapter
import com.example.aston_intensiv_3.recycler.ContactDeleteAdapter

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
        adapter.submitList(viewModel.contactsList)

        val deleteAdapter = ContactDeleteAdapter {
            it.isDelete = !it.isDelete
        }
        deleteAdapter.submitList(viewModel.contactsList)

        if (viewModel.isDeleteMode()) {
            binding.recyclerView.adapter = deleteAdapter
        } else {
            binding.recyclerView.adapter = adapter
        }
        changeButtons()

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_contactListFragment_to_addContactFragment2)
        }

        binding.fab.setOnClickListener {
            viewModel.turnOnDeleteMode()
            changeButtons()
            binding.recyclerView.adapter = deleteAdapter
        }

        binding.cancelButton.setOnClickListener {
            viewModel.turnOffDeleteMode()
            changeButtons()
            binding.recyclerView.adapter = adapter
            viewModel.resetSelectedContacts()
        }

        binding.deleteButton.setOnClickListener {
            viewModel.turnOffDeleteMode()
            changeButtons()
            binding.recyclerView.adapter = adapter
            viewModel.deleteSelectedContacts()
            Toast.makeText(context, R.string.contacts_deleted, LENGTH_SHORT).show()
        }
        return binding.root
    }

    private fun changeButtons() {

        if (viewModel.isDeleteMode()) {
            binding.deleteButton.visibility = View.VISIBLE
            binding.cancelButton.visibility = View.VISIBLE
            binding.addButton.visibility = View.INVISIBLE
            binding.fab.visibility = View.INVISIBLE
        } else {
            binding.deleteButton.visibility = View.GONE
            binding.cancelButton.visibility = View.GONE
            binding.addButton.visibility = View.VISIBLE
            binding.fab.visibility = View.VISIBLE
        }
    }
}