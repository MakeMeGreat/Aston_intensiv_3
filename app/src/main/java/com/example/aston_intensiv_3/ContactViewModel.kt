package com.example.aston_intensiv_3

import androidx.lifecycle.ViewModel
import com.example.aston_intensiv_3.data.Contact
import com.example.aston_intensiv_3.data.ContactsList

class ContactViewModel : ViewModel() {

    var isDeleteMode: Boolean = false

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

    fun updateContact(id: Int, name: String, lastName: String, number: String) {
        val index = contactsList.indexOfFirst { it.id == id }
        contactsList[index] = Contact(id, name, lastName, number)
    }

    fun changeDeleteMode() {
        isDeleteMode = !isDeleteMode
    }
}