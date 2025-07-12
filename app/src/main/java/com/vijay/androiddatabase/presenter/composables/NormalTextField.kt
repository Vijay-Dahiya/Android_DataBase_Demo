package com.vijay.androiddatabase.presenter.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextField(
    modifier: Modifier = Modifier,
    reset : Boolean,
    onChange : (String) -> Unit
) {
    var valueInput by remember { mutableStateOf("") }
    if (reset) {
        LaunchedEffect(Unit) {
            valueInput = ""
        }
    }
    TextField(
        modifier = modifier.fillMaxWidth(),
        textStyle = TextStyle.Default.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        value = valueInput,
        onValueChange = {it->
            valueInput = it
            onChange(valueInput)
        }
    )
}