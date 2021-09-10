package com.example.jsmall.mvvmarchitecture

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel(private val activity: Activity, context: Context, private val mauth : FirebaseAuth) : ViewModel() {

    private val authRepo = AuthRepository(context,mauth, activity)
    fun registerUser(email : String, pass : String){
        authRepo.registerUser(email, pass)
    }
    fun loginUser(email : String, pass : String){
        authRepo.loginUser(email, pass)
    }
    fun logOut(){
        authRepo.logOut()
    }
    fun forgotPassword(email: String){
        authRepo.forgotPassword(email)
    }
}