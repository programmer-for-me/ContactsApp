package com.example.roomdatabasejetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabasejetpackcompose.DB.entities.User

@Composable
fun ContactItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        content = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ){
                    Text(
                        text = user.name,
                        fontSize = 18.sp
                    )
                    Text(
                        text = user.phoneNumber,
                        fontSize = 18.sp
                    )
                }
            }

        }
    )
}


@Preview(showBackground = true)
@Composable
private fun testUI() {
    ContactItem(user = User(name = "Sam", phoneNumber = "+998909998877"))
}