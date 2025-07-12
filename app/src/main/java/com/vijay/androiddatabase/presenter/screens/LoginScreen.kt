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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.vijay.androiddatabase.domain.showToast
import com.vijay.androiddatabase.presenter.composables.NormalTextField
import com.vijay.androiddatabase.presenter.composables.NormalButton

@Composable
fun LoginScreen(
    onLoginClick : (
        email: String,
        pass : String,
    ) -> Boolean,
    onLoginSuccess : () -> Unit,
    onRegisterClick : () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            var reset by remember { mutableStateOf(false) }
            var email by remember { mutableStateOf("") }
            var pass by remember { mutableStateOf("") }

            NormalTextField(reset= reset) { email = it }
            Spacer(modifier = Modifier.height(12.dp))
            NormalTextField(reset= reset) { pass = it }
            Spacer(modifier = Modifier.height(20.dp))
            NormalButton(
                text = "Login"
            ) {
                val isRegister = onLoginClick(email, pass)
                if (isRegister) {
                    context.showToast("Success !!")
                    onLoginSuccess()
                } else {
                    context.showToast("Email and Password didn't matched! ")
                }
            }
        }
        Text(
            modifier = Modifier
                .padding(25.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    onRegisterClick()
                }
            ,
            text = "Register?"
        )
    }

}