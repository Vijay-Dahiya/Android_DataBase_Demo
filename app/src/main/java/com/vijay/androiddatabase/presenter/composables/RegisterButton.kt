package com.vijay.androiddatabase.presenter.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NormalButton(
    modifier: Modifier = Modifier,
    text : String = "Register",
    onClick : () -> Unit
) {
    TextButton(
        modifier = modifier.padding(12.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black)
            .fillMaxWidth(),
        onClick = {
            onClick()
        },
    ) {
        Text(
            text = text,
            color = Color.White,
        )
    }
}