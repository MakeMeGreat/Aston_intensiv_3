package com.example.aston_intensiv_3.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.aston_intensiv_3.data.Contact
import com.example.aston_intensiv_3.databinding.FragmentContactItemBinding

class ContactDeleteAdapter(
    private val onContactClicked: (Contact) -> Unit,
) : ListAdapter<Contact, ContactDeleteAdapter.ContactViewHolder>(ContactDiffUtil) {

    class ContactViewHolder(private val binding: FragmentContactItemBinding) :
        ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.contactName.text = contact.name
            binding.contactLastName.text = contact.lastName
            binding.contactNumber.text = contact.number
            binding.isSelectedCheckBox.visibility = View.VISIBLE
            binding.isSelectedCheckBox.isChecked = contact.isDelete
        }

        fun updateCheckBox(contact: Contact) {
            binding.isSelectedCheckBox.isChecked = contact.isDelete
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
            holder.updateCheckBox(current)
        }
        holder.bind(current)
    }
}