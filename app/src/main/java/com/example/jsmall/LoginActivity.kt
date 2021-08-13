package com.example.jsmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.jsmall.mvvmarchitecture.AuthViewModel
import com.example.jsmall.mvvmarchitecture.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

private lateinit var mauth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         mauth = FirebaseAuth.getInstance()

        stosignin.setOnClickListener {
           signinlayout.visibility = View.GONE
            scroll.visibility = View.VISIBLE
        }

        rtosignin.setOnClickListener {
            signinlayout.visibility = View.VISIBLE
            scroll.visibility = View.GONE
        }
        rcancle.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        scancle.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        saccbtn.setOnClickListener {
            val email = semail.text.toString().trim()
            val pass = scpass.text.toString().trim()
            if (email.isEmpty() || pass.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                toast("Enter Valid Data")
            }
            else{
                val authViewModel = ViewModelProvider(this, AuthViewModelFactory(this,this, mauth)).get(AuthViewModel::class.java)
                authViewModel.loginUser( email, pass)
                saccbtn.isEnabled = false
            }

        }
        raccbtn.setOnClickListener {
            val remail = remail.text.toString().trim()
            val rpass = rpass.text.toString().trim()
            val rcpass = rcpass.text.toString().trim()
            val rnam = rname.text.toString().trim()

            if(remail.isEmpty() || rpass.isEmpty() || rcpass.isEmpty() || rnam.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(remail).matches() || (rpass != rcpass)){
                toast("Enter All Data \n OR Enter Valid Data")
            }
            else{
                val authViewModel = ViewModelProvider(this, AuthViewModelFactory(this, this, mauth)).get(AuthViewModel::class.java)
                authViewModel.registerUser(remail, rpass)
                raccbtn.isEnabled = false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(mauth.currentUser != null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}