package ua.ck.zabochen.serviceapp.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.log(tag: String, message: String) {
    Log.i(tag, message)
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}