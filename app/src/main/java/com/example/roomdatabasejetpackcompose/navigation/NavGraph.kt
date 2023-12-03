package com.example.roomdatabasejetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomdatabasejetpackcompose.AddContactScreen
import com.example.roomdatabasejetpackcompose.ContactListScreen

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.ContactList.route)
    {
        composable(route = Screens.AddContact.route){
            AddContactScreen(navController)
        }
        composable(route = Screens.ContactList.route){
            ContactListScreen(navController)
        }
    }
}