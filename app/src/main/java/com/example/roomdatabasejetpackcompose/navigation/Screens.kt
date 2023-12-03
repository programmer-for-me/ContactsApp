package com.example.roomdatabasejetpackcompose.navigation

sealed class Screens(val route: String) {
    object AddContact: Screens("add_contact_screen")
    object ContactList: Screens("contact_list_screen")
}
