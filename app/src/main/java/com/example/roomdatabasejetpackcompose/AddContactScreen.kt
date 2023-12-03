package com.example.roomdatabasejetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabasejetpackcompose.DB.AppDatabase
import com.example.roomdatabasejetpackcompose.DB.entities.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(navHostController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val context = LocalContext.current
    val db = AppDatabase.getInstance(context)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            label = { Text("Enter Name") }
        )

        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            label = { Text("Enter Phone Number") }
        )

        Button(
            onClick = {
                  if(name.isNotEmpty() && phoneNumber.isNotEmpty()) {
                      db.getUserDao().insertUser(User(name = name, phoneNumber = phoneNumber))
                      navHostController.navigate("contact_list_screen")
                  }
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "Add Contact", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddContactScreenPreview () {
    val navController = rememberNavController()
    AddContactScreen(navController)
}
