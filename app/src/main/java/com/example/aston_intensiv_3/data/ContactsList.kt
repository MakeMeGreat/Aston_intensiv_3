package com.example.aston_intensiv_3.data

import androidx.lifecycle.LiveData

typealias ContactsListener = (contacts: List<Contact>) -> Unit

class ContactsList() {

   private val listeners = mutableSetOf<ContactsListener>()


     val contacts = mutableListOf<Contact>(
        Contact(1, "Abraham", "Johnson", "1111"),
        Contact(2, "Adam", "Johnson", "1112"),
        Contact(3, "Bernard", "Johnson", "1113"),
        Contact(4, "Caleb", "Johnson", "1114"),
        Contact(5, "Chad", "Johnson", "1115"),
        Contact(6, "Derek", "Johnson", "1116"),
        Contact(7, "Douglas", "Johnson", "1117"),
        Contact(8, "Edgar", "Johnson", "1118"),
        Contact(9, "Eric", "Johnson", "1119"),
        Contact(10, "Gregory", "Johnson", "1120"),
        Contact(11, "Abraham", "Johnson", "1121"),
        Contact(12, "Adam", "Johnson", "1122"),
        Contact(13, "Bernard", "Johnson", "1123"),
        Contact(14, "Caleb", "Johnson", "1124"),
        Contact(15, "Chad", "Johnson", "1125"),
        Contact(16, "Derek", "Johnson", "1126"),
        Contact(17, "Douglas", "Johnson", "1127"),
        Contact(18, "Edgar", "Johnson", "1128"),
        Contact(19, "Eric", "Johnson", "1129"),
        Contact(20, "Gregory", "Johnson", "1130"),
    )
    fun getContactList() = contacts

   /*fun addListener(listener: ContactsListener) {
      listeners.add(listener)
      listener.invoke(contacts)
   }

   fun removeListener(listener: ContactsListener) {
      listeners.remove(listener)
   }

   private fun notifyChanges() {
      listeners.forEach { it.invoke(contacts) }
      }
      */

}
