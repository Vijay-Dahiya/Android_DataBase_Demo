package com.vijay.androiddatabase.presenter.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vijay.androiddatabase.presenter.utils.UserData

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    userData: UserData?,
    onBackClick : () -> Unit,
    getAllUserClick : () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier,
                text = "Name : ${userData?.name}"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier,
                text = "Email : ${userData?.email}"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier,
                text = "Gender : ${userData?.gender}"
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        Text(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.TopStart)
                .clickable {
                    onBackClick()
                }
            ,
            text = "<- Back"
        )

        Text(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    getAllUserClick()
                }
            ,
            text = "All Users"
        )
    }
}