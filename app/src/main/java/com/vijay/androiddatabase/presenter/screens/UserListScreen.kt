package com.vijay.androiddatabase.presenter.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.vijay.androiddatabase.presenter.utils.UserData

@Composable
fun UserListScreen(
    usersList: List<UserData?>,
    onBackClick : () -> Unit
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            items(usersList) {
                Spacer(modifier = Modifier.height(6.dp))
                UserListItem(it)
                Spacer(modifier = Modifier.height(6.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(Color.Black)
                )
            }
        }

        Text(
            modifier = Modifier
                .background(Color.Red)
                .padding(25.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    onBackClick()
                }
            ,
            text = "LogOut?"
        )
    }

}

@Composable
fun UserListItem(userData: UserData?) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ){
        Text(
            modifier = Modifier,
            text = "Name :\n${userData?.name}"
        )
        Spacer(modifier = Modifier.background(Color.Black).width(20.dp))
        Text(
            modifier = Modifier,
            text = "Email :\n${userData?.email}"
        )
        Spacer(modifier = Modifier.background(Color.Black).width(20.dp))
        Text(
            modifier = Modifier,
            text = "Gender :\n${userData?.gender}"
        )
    }
}