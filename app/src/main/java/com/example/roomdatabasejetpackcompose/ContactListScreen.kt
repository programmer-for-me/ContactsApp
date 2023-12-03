package com.example.roomdatabasejetpackcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabasejetpackcompose.DB.AppDatabase

@Composable
fun ContactListScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    val db = AppDatabase.getInstance(context)
    val users = db.getUserDao().getAllUsers()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = users,
            itemContent = {
                ContactItem(user = it)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun testUI() {
    val navHostController = rememberNavController()
    ContactListScreen(navHostController = navHostController)
}