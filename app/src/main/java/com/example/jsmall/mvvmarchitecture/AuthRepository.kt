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
import kotlinx.android.synthetic.main.activity_login.*

class AuthRepository(private val context: Context, private val mauth : FirebaseAuth ){

    fun registerUser( activity: Activity, email : String,  pass : String){
        mauth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    activity.raccbtn.isEnabled = true
                    context.startActivity(Intent(context,MainActivity::class.java))
                    activity.finish()
                }
                else{
                    activity.raccbtn.isEnabled = true
                    Toast.makeText(context,it.exception!!.message,Toast.LENGTH_LONG).show()
                }
            }

    }
    fun loginUser(  activity: Activity, email : String,  pass : String){
        mauth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    activity.saccbtn.isEnabled = true
                    context.startActivity(Intent(context,MainActivity::class.java))
                    activity.finish()
                }
                else{
                    activity.saccbtn.isEnabled = true
                    Toast.makeText(context,it.exception!!.message,Toast.LENGTH_LONG).show()

                }
            }

    }
    fun logOut(){
        mauth.signOut()
    }
}


