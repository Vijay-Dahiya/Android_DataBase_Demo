package com.vijay.androiddatabase.domain

import android.content.Context
import android.widget.Toast

fun Context.showToast(text : String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}