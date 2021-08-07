package com.example.jsmall.mvvmarchitecture

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel(private val activity: Activity, context: Context, private val mauth : FirebaseAuth) : ViewModel() {

    private val authRepo = AuthRepository(context,mauth)
    fun registerUser(email : String, pass : String){
        authRepo.registerUser(activity, email, pass)
    }
    fun loginUser(email : String, pass : String){
        authRepo.loginUser(activity, email, pass)
    }
    fun logOut(){
        authRepo.logOut()
    }
}