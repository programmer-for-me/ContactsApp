package com.example.roomdatabasejetpackcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    FloatingActionButton(
        onClick = {
            navHostController.navigate("add_contact_screen")
        },
        containerColor = MaterialTheme.colorScheme.secondary,
        shape = RoundedCornerShape(16.dp),
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Add FAB",
            tint = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun testUI() {
    val navHostController = rememberNavController()
    ContactListScreen(navHostController = navHostController)
}