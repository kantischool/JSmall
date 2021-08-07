package com.example.jsmall

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.Logout(){
    startActivity(Intent(this, LoginActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })

}
fun Context.toast (message: String) =
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()