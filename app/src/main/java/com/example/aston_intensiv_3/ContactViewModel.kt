package com.example.aston_intensiv_3

import androidx.lifecycle.ViewModel
import com.example.aston_intensiv_3.data.Contact
import com.example.aston_intensiv_3.data.ContactsList

class ContactViewModel : ViewModel() {

    private var isDeleteMode: Boolean = false
    var contactsList: MutableList<Contact> = ContactsList().contacts
    private var nextContactId = 101

    fun addContact(
        name: String,
        lastName: String,
        number: String
    ) {
        val newContact = Contact(nextContactId++, name, lastName, number)
        contactsList.add(newContact)
    }

    fun updateContact(id: Int, name: String, lastName: String, number: String, isDelete: Boolean) {
        val index = contactsList.indexOfFirst { it.id == id }
        contactsList[index] = Contact(id, name, lastName, number, isDelete)
    }

    fun resetSelectedContacts() {
        contactsList.forEach {
            if (it.isDelete) it.isDelete = false
        }
    }

    fun deleteSelectedContacts() {
        contactsList.removeAll {
            it.isDelete
        }
    }

    fun turnOnDeleteMode() {
        isDeleteMode = true
    }

    fun turnOffDeleteMode() {
        isDeleteMode = false
    }

    fun isDeleteMode() = isDeleteMode
}