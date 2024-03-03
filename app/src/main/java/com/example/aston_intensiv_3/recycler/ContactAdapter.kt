package com.example.aston_intensiv_3.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.aston_intensiv_3.data.Contact
import com.example.aston_intensiv_3.databinding.FragmentContactItemBinding

class ContactAdapter(
    private val onContactClicked: (Contact) -> Unit
) : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(ContactDiffUtil) {

    class ContactViewHolder(val binding : FragmentContactItemBinding) : ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.contactName.text = contact.name
            binding.contactLastName.text = contact.lastName
            binding.contactNumber.text = contact.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(
            FragmentContactItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onContactClicked(current)
        }
        val contact = getItem(position)
        holder.bind(contact)
    }

    companion object ContactDiffUtil :  DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }
    }
}