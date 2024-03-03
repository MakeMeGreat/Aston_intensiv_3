package com.example.aston_intensiv_3

import android.app.Notification.Action
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aston_intensiv_3.data.ContactsList
import com.example.aston_intensiv_3.databinding.FragmentContactListBinding
import com.example.aston_intensiv_3.recycler.ContactAdapter

class ContactListFragment : Fragment() {

    private val viewModel : ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentContactListBinding.inflate(inflater)
        val adapter = ContactAdapter{
            val action = ContactListFragmentDirections.actionContactListFragmentToUpdateContactFragment(it.id)
            findNavController().navigate(action)
        }
        binding.toolbar.inflateMenu(R.menu.app_menu)
        val contacts = viewModel.contactsList
        adapter.submitList(contacts.value)
//        contacts.observe(this.viewLifecycleOwner) {contacts ->
//            contacts.let {
//                adapter.submitList(it)
//            }
//        }
        binding.recyclerView.adapter = adapter
        binding.addButton.setOnClickListener{
            findNavController().navigate(R.id.action_contactListFragment_to_addContactFragment2)
        }

        return binding.root
    }
}