package com.example.jsmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jsmall.modelclass.DataModel
import com.example.jsmall.mvvmarchitecture.AuthViewModel
import com.example.jsmall.mvvmarchitecture.AuthViewModelFactory
import com.example.jsmall.mvvmarchitecture.DataViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataViewModel : DataViewModel
    private val dataList : ArrayList<DataModel> = ArrayList()

    private lateinit var mauth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        mauth = FirebaseAuth.getInstance()
        
        dataViewModel.getData().observe(this, Observer {
            dataList.addAll(it)
            val adapter = DataAdapter(this,dataList)
            datarecycler.adapter = adapter
            datarecycler.layoutManager = GridLayoutManager(this,2)
            progress.visibility = View.GONE

        })

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item?.itemId == R.id.action_logout){

            AlertDialog.Builder(this).apply{
                setTitle("Are you sure to Logout?")
                setNegativeButton("No"){_,_ ->

                }
                setPositiveButton("Yes"){ _,_ ->
                    val authViewModel = ViewModelProvider(this@MainActivity, AuthViewModelFactory(this@MainActivity, this@MainActivity, mauth)).get(AuthViewModel::class.java)
                    authViewModel.logOut()
                    Logout()
                }

            }.create().show()
        }
        return super.onOptionsItemSelected(item)
    }
}