package com.example.contactsapp

class Contacts {


    fun getInfo():List<Collect> {

        val contacts = mutableListOf<Collect>()

        contacts.add(Collect(
            R.drawable.uncle ,
            R.string.uncle,
            R.string.num_uncle,
        ))
        contacts.add(Collect(
            R.drawable.auntie,
            R.string.auntie,
            R.string.num_auntie,
        ))
        contacts.add(Collect(
            R.drawable.brother,
            R.string.brother,
            R.string.num_brother,
        ))
        contacts.add(Collect(
            R.drawable.granny,
            R.string.granny,
            R.string.num_granny,
        ))
        contacts.add(Collect(
            R.drawable.grandfather,
            R.string.grandfather,
            R.string.num_grandfather,
        ))
        contacts.add(Collect(
            R.drawable.daughter,
            R.string.daughter,
            R.string.num_daughter,
        ))
        contacts.add(Collect(
            R.drawable.son,
            R.string.son,
            R.string.num_son,
        ))
        contacts.add(Collect(
            R.drawable.friend_1,
            R.string.friend1,
            R.string.num_friend1,
        ))
        contacts.add(Collect(
            R.drawable.friend_2,
            R.string.friend2,
            R.string.num_friend2,
        ))
        contacts.add(Collect(
            R.drawable.neigbour,
            R.string.neighbour,
            R.string.num_neighbour,
        ))
        contacts.add(Collect(
            R.drawable.adel_shakel,
            R.string.adel,
            R.string.num_adel,
        ))

        return contacts
    }
}