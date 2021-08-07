package com.example.jsmall.mvvmarchitecture

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.jsmall.LoginActivity
import com.example.jsmall.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository(private val context: Context, private val mauth : FirebaseAuth ){

   // var application: Application? = application
    var firebaseuserData : MutableLiveData<FirebaseUser> = MutableLiveData()
    var firebaseuserStatus : MutableLiveData<Boolean> = MutableLiveData()
   // var mauth : FirebaseAuth = FirebaseAuth.getInstance()

//    constructor(application: Application?){
//        this.application = application
//        mauth = FirebaseAuth.getInstance()
//        firebaseuserData = MutableLiveData()
//        firebaseuserStatus = MutableLiveData()
//        if (mauth.currentUser != null){
//            firebaseuserData.value = mauth.currentUser
//        }
//    }

    fun registerUser( activity: Activity, email : String,  pass : String){
        mauth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    context.startActivity(Intent(context,MainActivity::class.java))
                    activity.finish()
                }
                else{
                    Toast.makeText(context,it.exception!!.message,Toast.LENGTH_LONG).show()
                }
            }

    }
    fun loginUser(  activity: Activity, email : String,  pass : String){
        mauth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    context.startActivity(Intent(context,MainActivity::class.java))
                    activity.finish()
                }
                else{
                    Toast.makeText(context,it.exception!!.message,Toast.LENGTH_LONG).show()

                }
            }

    }
    fun logOut(){
        mauth.signOut()
    }
}


