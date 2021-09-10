package com.example.jsmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    val mauth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        SystemClock.sleep(3000)
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    override fun onStart() {
        super.onStart()
       if (mauth.currentUser != null){
           startActivity(Intent(this,MainActivity::class.java))
           finish()
       }
    }
}